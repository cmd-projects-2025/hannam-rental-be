package com.hannam.rental.hannam_rental.repository;

import com.hannam.rental.hannam_rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> retrieve();
}
