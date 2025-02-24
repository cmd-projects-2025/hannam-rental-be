package com.hannam.rental.hannam_rental.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rental {
    @Id
    @Column(unique = true, nullable = false)
    private Integer rentalNumber;

    @Column(nullable = false, length = 20)
    private String rentalDate;

    @Column(nullable = false, unique = true, length = 20)
    private String returnDate;

    @Column(nullable = false)
    private Boolean retrieve;

    @Column(nullable = false, unique = true, length = 20)
    private String studentId;

    @Column
    private Integer productNumber;

    @Column(nullable = false, length = 20)
    private String college;

    @Builder
    public Rental(String rentalDate, String returnDate, Boolean retrieve, String studentId, Integer productNumber, String college) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.retrieve = retrieve;
        this.studentId = studentId;
        this.productNumber = productNumber;
        this.college = college;
    }
}
