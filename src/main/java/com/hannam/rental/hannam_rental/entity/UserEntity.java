package com.hannam.rental.hannam_rental.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "STUDENT_ID", unique = true, nullable = false, length = 20) // 학번 겸 아이디(유일성, null값 허용X, CHAR(20))
    private String studentId;

    @Column(nullable = false, length = 20) //비밀번호(null 값 허용 X, CHAR(20))
    private String password;

    @Column(nullable = false, unique = true, length = 20) //전화번호(null 값 허용 X, 유일성, CHAR(20))
    private String phoneNumber;

    @Column(nullable = false, length = 50)//이름(null 값 허용 , VARCHAR(50))
    private String userName;
}
