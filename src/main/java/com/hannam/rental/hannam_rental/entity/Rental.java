package com.hannam.rental.hannam_rental.entity;


import jakarta.persistence.*;
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
    @Column(name="rental_number", unique = true, nullable = false)
    private Integer rentalNumber;

    @Column(name="rental_date", nullable = false, length = 50)
    private String rentalDate;

    @Column(name="return_number", nullable = false, length = 50)
    private String returnDate;

    @Column(name="retrieve_", nullable = false)
    private Boolean retrieve;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="student_id", referencedColumnName = "student_id")
    private User studentId;

    @Column(name="product_number", nullable = false)
    private Integer productNumber;

    @Column(name="college_", nullable = false, length = 50)
    private String college;

    @Builder
    public Rental(String rentalDate, String returnDate, Boolean retrieve, User studentId, Integer productNumber, String college) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.retrieve = retrieve;
        this.studentId = studentId;
        this.productNumber = productNumber;
        this.college = college;
    }
}
