package com.hannam.rental.hannam_rental.entity;

import jakarta.persistence.*;

public class Product {
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="rental_number", referencedColumnName = "rental_number")
    private Rental rentalNumber;

    @Column(name="product_", nullable = false, length = 50)
    private String product;

    public Product(Rental rentalNumber, String product) {
        this.rentalNumber = rentalNumber;
        this.product = product;
    }
}
