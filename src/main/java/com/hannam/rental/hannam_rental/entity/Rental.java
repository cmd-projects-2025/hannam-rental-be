package com.hannam.rental.hannam_rental.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Rental { //대여정보
    @Id
    @Column(unique = true, nullable = false)
    private Integer rentalNumber;

    @Column(nullable = false, length = 20)
    private LocalDate rentalDate;

    @Column(nullable = false, unique = true, length = 20)
    private LocalDate returnDate;

    @Column(nullable = false)
    private Boolean retrieve;

    @Column(name = "student_id", nullable = false, length = 20)
    private String studentId;

    @ManyToOne(fetch = FetchType.LAZY) //다대일 일때 지연로딩
    @JoinColumn(name = "product_number", referencedColumnName = "product_number", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private College college;

    @Builder
    public Rental(LocalDate rentalDate, LocalDate returnDate, Boolean retrieve, String studentId, Product product, College college) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.retrieve = retrieve;
        this.studentId = studentId;
        this.product = product;
        this.college = college;
    }
}
