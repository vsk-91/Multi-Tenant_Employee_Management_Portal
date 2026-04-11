package com.vsk.mtep.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vsk.mtep.dto.LoginRequest;
import com.vsk.mtep.dto.LoginResponse;
import com.vsk.mtep.dto.RegisterRequest;
import com.vsk.mtep.service.AuthService;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
     private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        authService.registerCompany(request);
        return "Company registered successfully";
    }
    @PostMapping("/login")
public LoginResponse login(@RequestBody LoginRequest request) {
    return authService.login(request);
}
}
