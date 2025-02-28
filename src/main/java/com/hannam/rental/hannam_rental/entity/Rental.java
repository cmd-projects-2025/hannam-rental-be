package com.hannam.rental.hannam_rental.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Rental")
public class Rental { //대여정보
    @Id
    @Column(name="rental_number", unique = true, nullable = false)
    private Integer rentalNumber;

    @Column(name="rental_date", nullable = false, length = 50)
    private String rentalDate;

    @Column(name="return_number", nullable = false, length = 50)
    private String returnDate;

    @Column(name="retrieve_", nullable = false)
    private Boolean retrieve;

    @JoinColumn(name = "student_id", nullable = false)
    private String studentId;

    @ManyToOne(fetch = FetchType.LAZY) //다대일 일때 지연로딩
    @JoinColumn(name = "product_number", referencedColumnName = "product_number", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private College college;
}
