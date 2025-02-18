package com.hannam.rental.hannam_rental.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")

public class UserController {

    @GetMapping("/")
    public String users() {
        return "회원가입";
    }
    @GetMapping("/login")
    public String login() {
        return "로그인";
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
