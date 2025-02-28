package com.hannam.rental.hannam_rental.repository;

import com.hannam.rental.hannam_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//회원정보 조회
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByStudentId(String studentId);
    Optional<User> findByPhoneNumber(String phoneNumber);
}
