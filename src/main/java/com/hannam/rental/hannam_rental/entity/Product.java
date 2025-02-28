package com.hannam.rental.hannam_rental.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_number")
    private Integer productNumber;

    @Column(name = "product_name")
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "college")
    private College college;

    public Product(String productName, College college) {
        this.productName = productName;
        this.college = college;
    }

    public Integer getProductNumber() { return productNumber; }
    public void setProductNumber(Integer productNumber) { this.productNumber = productNumber; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public College getCollege() { return college; }
    public void setCollege(College college) { this.college = college; }
}