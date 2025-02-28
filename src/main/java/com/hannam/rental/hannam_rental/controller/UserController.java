package com.hannam.rental.hannam_rental.controller;

import com.hannam.rental.hannam_rental.dto.UserDto;
import com.hannam.rental.hannam_rental.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register") //회원가입-Post
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @GetMapping("/signup")
    public String signup() {
        return "회원가입";
    }

    @GetMapping("/home")
    public String home() {
        return "홈화면";
    }


    @GetMapping("/logout")
    public String logout() {
        return "로그아웃";
    }
}
