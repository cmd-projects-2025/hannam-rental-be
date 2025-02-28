package com.hannam.rental.hannam_rental.controller;

import com.hannam.rental.hannam_rental.dto.MyPageDto;
import com.hannam.rental.hannam_rental.entity.User;
import com.hannam.rental.hannam_rental.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class MyPageController {

    private final UserService userService;

    public MyPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mypage")
    public ResponseEntity<MyPageDto> getMyPage(HttpSession session) {
        User user = (User) session.getAttribute("user"); // 세션에서 사용자 정보 가져오기
        if (user == null) {
            return ResponseEntity.status(401).build(); // 인증되지 않은 경우 401 반환
        }

        MyPageDto myPageDto = userService.getMyPageInfo(user.getStudentId()); // 서비스에서 데이터 조회
        return ResponseEntity.ok(myPageDto); // JSON 형태로 응답
    }
}
