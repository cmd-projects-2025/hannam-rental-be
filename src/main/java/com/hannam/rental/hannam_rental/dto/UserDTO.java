package com.hannam.rental.hannam_rental.dto;

import com.hannam.rental.hannam_rental.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {
    private String studentId;
    private String password;
    private String phoneNumber;
    private String userName;

    public static UserDTO toUserDTO (UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setStudentId(userEntity.getStudentId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setPhoneNumber(userEntity.getPhoneNumber());
        userDTO.setUserName(userEntity.getUserName());

        return userDTO;
    }
}
