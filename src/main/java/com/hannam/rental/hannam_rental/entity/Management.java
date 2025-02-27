package com.hannam.rental.hannam_rental.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Management { //상품관리
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 자동증가PK(JPA에서내부적으로관리)

    @Column(nullable = false, length = 50)
    private String college; // 단과대학

    @ManyToOne(fetch = FetchType.LAZY) //지연에러
    @JoinColumn(name = "product_number", referencedColumnName = "product_number", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
