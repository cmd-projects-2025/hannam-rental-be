package com.hannam.rental.hannam_rental.service;

import com.hannam.rental.hannam_rental.dto.MyPageDto;
import com.hannam.rental.hannam_rental.dto.UserDto;
import com.hannam.rental.hannam_rental.entity.Rental;
import com.hannam.rental.hannam_rental.entity.User;
import com.hannam.rental.hannam_rental.repository.RentalRepository;
import com.hannam.rental.hannam_rental.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RentalRepository rentalRepository;

    //생성자 주입
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RentalRepository rentalRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.rentalRepository = rentalRepository;
    }

    public void register(UserDto userDto) {
        validateDuplicateUser(userDto); // 중복 체크
        User user = User.builder()
                .studentId(userDto.getStudentId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
                .build();

        userRepository.save(user); // 저장
    }

    private void validateDuplicateUser(UserDto userDto) {
        userRepository.findByStudentId(userDto.getStudentId())
                .ifPresent(user -> { throw new IllegalArgumentException("이미 존재하는 ID 입니다."); });//중복 이름 확인

        userRepository.findByPhoneNumber(userDto.getPhoneNumber())
                .ifPresent(user -> { throw new IllegalArgumentException("이미 사용 중인 전화번호입니다."); }); //중복 전화번호 확인
    }

    //DTO -> 엔티티 변환
    private User convertToEntity(UserDto userDto) {
        return User.builder()
                .studentId(userDto.getStudentId())
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
    }

    //로그인 세션 기능
    public User authenticate(String studentId, String password) {
        User user = userRepository.findByStudentId(studentId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }
        return user;
    }

    public MyPageDto getMyPageInfo(String studentId) {
        User user = userRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        Rental rental = (Rental) rentalRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        List<Rental> myPage = rentalRepository.findByRentalDate(rental.getRentalDate());

        if (myPage.isEmpty()) {
            return new MyPageDto(user.getName(), "대여 내역 없음", "", "");
        }

        MyPageDto rentalInfo = (MyPageDto) myPage;
        return new MyPageDto(user.getName(), rentalInfo.getProduct(), rentalInfo.getRentalDate(), rentalInfo.getRetrieve());
    }
}
