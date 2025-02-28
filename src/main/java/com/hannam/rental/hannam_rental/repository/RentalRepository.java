package com.hannam.rental.hannam_rental.repository;

import com.hannam.rental.hannam_rental.dto.MyPageDto;
import com.hannam.rental.hannam_rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByRetrieveFalse();
    List<Rental> findByRentalDate(String rentalDate);
    Optional<Object> findByStudentId(String studentId);
}
