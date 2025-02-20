package com.hannam.rental.hannam_rental.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")

public class UserController {

    @PostMapping("/signup")
    public String signup() {
        return "회원가입";
    }
    @PostMapping("/users/login")
    public <UserDTO> login(@ModelAttribute UserDTO userDTO) {
        return "로그인";
    }
    @GetMapping("/users/home")
    public String home() {
        return "홈화면";
    }
    @GetMapping("/user/home/myPage")
    public String myPage() {
        return "마이페이지";
    }
    @GetMapping("/users/home/select")
    public String select() {
        return "대여장소선택";
    }
    @GetMapping("/user/home/select/list")
    public String list() {
        return "대여물품목록";
    }
    @GetMapping("/user/home/select/list/apply")
    public String apply() {
        return "신청페이지";
    }
    @PutMapping("/users/logout")
    public String logout() {
        return "로그아웃";
    }
}
