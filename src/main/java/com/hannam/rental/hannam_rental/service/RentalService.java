package com.hannam.rental.hannam_rental.service;

import com.hannam.rental.hannam_rental.dto.RentalRequestDto;
import com.hannam.rental.hannam_rental.dto.RentalResponseDto;
import com.hannam.rental.hannam_rental.entity.Rental;
import com.hannam.rental.hannam_rental.entity.User;
import com.hannam.rental.hannam_rental.entity.Product;
import com.hannam.rental.hannam_rental.entity.College;
import com.hannam.rental.hannam_rental.repository.RentalRepository;
import com.hannam.rental.hannam_rental.repository.UserRepository;
import com.hannam.rental.hannam_rental.repository.ProductRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<RentalResponseDto> getAvailableRentals() {
        List<Rental> rentals = rentalRepository.findByRetrieveFalse();
        return rentals.stream().map(rental -> {
            RentalResponseDto dto = new RentalResponseDto();
            dto.setRentalDate(rental.getRentalDate());
            dto.setReturnDate(rental.getReturnDate());
            dto.setRetrieve(rental.getRetrieve());
            dto.setStudentId(rental.getStudentId());
            dto.setProductNumber(rental.getProduct().getProductNumber());
            dto.setProductName(rental.getProduct().getProductName());
            dto.setCollege(rental.getCollege().getCollegeName());
            return dto;
        }).collect(Collectors.toList());
    }

    public void applyRental(RentalRequestDto rentalRequestDto) {
        if (rentalRequestDto.getStudentId() == null || rentalRequestDto.getStudentId().trim().isEmpty()) {
            throw new IllegalArgumentException("학생 ID를 입력해야 합니다.");
        }
        if (rentalRequestDto.getProductNumber() == null) {
            throw new IllegalArgumentException("제품 번호를 입력해야 합니다.");
        }
        if (rentalRequestDto.getCollege() == null || rentalRequestDto.getCollege().trim().isEmpty()) {
            throw new IllegalArgumentException("단과대학을 입력해야 합니다.");
        }

        User user = userRepository.findByStudentId(rentalRequestDto.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다. studentId: " + rentalRequestDto.getStudentId()));

        Product product = productRepository.findById(rentalRequestDto.getProductNumber())
                .orElseThrow(() -> new IllegalArgumentException("제품을 찾을 수 없습니다. productNumber: " + rentalRequestDto.getProductNumber()));

        // Enum 값 변환
        College selectedCollege;
        try {
            selectedCollege = College.valueOf(rentalRequestDto.getCollege().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("올바른 단과대학을 선택해야 합니다. (ENGINEERING 또는 SMART_CONVERGENCE) 입력값: " + rentalRequestDto.getCollege());
        }

        Rental rental = Rental.builder()
                .studentId(user.getStudentId())
                .product(product)
                .rentalDate(LocalDate.now().toString())
                .retrieve(false)
                .college(selectedCollege)
                .build();

        rentalRepository.save(rental);
    }
}
