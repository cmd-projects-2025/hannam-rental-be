package com.hannam.rental.hannam_rental.controller;

import com.hannam.rental.hannam_rental.dto.RentalRequestDto;
import com.hannam.rental.hannam_rental.dto.RentalResponseDto;
import com.hannam.rental.hannam_rental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/home/select")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @GetMapping("")
    public ResponseEntity<String> selectRentalLocation() {
        return ResponseEntity.ok("대여장소선택");
    }

    @GetMapping("/list")
    public ResponseEntity<List<RentalResponseDto>> getAvailableRentals() {
        List<RentalResponseDto> rentals = rentalService.getAvailableRentals();
        return ResponseEntity.ok(rentals);
    }

    @GetMapping("/list/apply")
    public ResponseEntity<String> getRentalApplicationPage() {
        return ResponseEntity.ok("신청페이지");
    }

    @PostMapping("/list/apply")
    public ResponseEntity<String> applyRental(@RequestBody RentalRequestDto rentalRequestDto) {
        rentalService.applyRental(rentalRequestDto);
        return ResponseEntity.ok("대여 신청 완료!");
    }
}
