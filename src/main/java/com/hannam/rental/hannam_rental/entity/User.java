package com.hannam.rental.hannam_rental.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @Column(name = "student_id", unique = true, nullable = false, length = 20) // 학번 겸 아이디(유일성, null 허용X, CHAR(20))
    private String studentId;

    @Column(nullable = false, length = 255) //비밀번호(null 값 허용 X, VARCHAR(255))
    private String password;

    @Column(nullable = false, length = 50)//이름(null 값 허용 , VARCHAR(50))
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true, length = 20) //전화번호(null 값 허용 X, 유일성, CHAR(20))
    private String phoneNumber;
}
