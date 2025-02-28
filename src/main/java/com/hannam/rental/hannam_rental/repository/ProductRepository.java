package com.hannam.rental.hannam_rental.repository;

import com.hannam.rental.hannam_rental.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
