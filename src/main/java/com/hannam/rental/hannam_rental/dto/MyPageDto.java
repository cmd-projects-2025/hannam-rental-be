package com.hannam.rental.hannam_rental.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyPageDto {
    private final String name;
    private final String product;
    private final String rentalDate;
    private final String retrieve;

    public MyPageDto(String name, String product, String rentalDate, String retrieve) {
        this.name = name;
        this.product = product;
        this.rentalDate = rentalDate;
        this.retrieve = retrieve;
    }
}
