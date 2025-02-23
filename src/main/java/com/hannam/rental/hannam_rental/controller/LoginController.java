package com.hannam.rental.hannam_rental.controller;
import com.hannam.rental.hannam_rental.entity.User;
import com.hannam.rental.hannam_rental.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/users"))
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public <LoginRequest> ResponseEntity<String> login(@RequestBody LoginRequest request,
                                                       HttpSession session){
        User user = userService.authenticate(user.getStudentId(), user.getPassword());
        if(user != null){
            session.setAttribute("user", user);
            return ResponseEntity.ok().body("로그인 성공");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
    }

    @PutMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();  // 세션 삭제
        return ResponseEntity.ok("로그아웃 성공");
    }
}
