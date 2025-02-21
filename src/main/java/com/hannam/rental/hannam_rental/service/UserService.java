package com.hannam.rental.hannam_rental.service;

import com.hannam.rental.hannam_rental.dto.UserDto;
import com.hannam.rental.hannam_rental.entity.User;
import com.hannam.rental.hannam_rental.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    //생성자 주입
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
}
