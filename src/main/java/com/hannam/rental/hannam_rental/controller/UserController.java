package com.hannam.rental.hannam_rental.controller;

import com.hannam.rental.hannam_rental.dto.UserDto;
import com.hannam.rental.hannam_rental.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

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

    @GetMapping("/home/myPage")
    public String myPage() {
        return "마이페이지";
    }

    @GetMapping("/home/select")
    public String select() {
        return "대여장소선택";
    }

    @GetMapping("/home/select/list")
    public String list() {
        return "대여물품목록";
    }

    @GetMapping("/home/select/list/apply")
    public String apply() {
        return "신청페이지";
    }

    @GetMapping("/logout")
    public String logout() {
        return "로그아웃";
    }
}
