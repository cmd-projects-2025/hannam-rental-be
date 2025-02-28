package com.hannam.rental.hannam_rental.dto;

//import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalRequestDto {
    private String studentId;
    private Integer productNumber;
    private String college;
}
