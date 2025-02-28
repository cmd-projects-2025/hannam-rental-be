package com.hannam.rental.hannam_rental.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RentalResponseDto {
    private Integer rentalId;
    private String studentId;
    private Integer productNumber;
    private String productName;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private Boolean retrieve;
    private String college;
}
