package com.lmp.unmsm.auth.controller;

import com.lmp.unmsm.auth.helper.LoginHelper;
import com.lmp.unmsm.auth.model.LoginResponseDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginHelper loginHelper;

    @GetMapping("/test")
    public Map<String, String> test() {
        return Map.of("message", "Hello World!");
    }

    @PostMapping("/register")
    public String register(@RequestParam("firstName") String firstName, @RequestParam("password") String password, @RequestParam("lastName") String lastName, @RequestParam("email") String email ) {
        loginHelper.registerUser(firstName, lastName, email, password);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestParam String username, @RequestParam String password) {
        return loginHelper.login(username, password);
    }

    @GetMapping("/grant-code")
    public void grantCode(@RequestParam("code") String code,
                                      @RequestParam("scope") String scope,
                                      @RequestParam("authuser") String authUser,
                                      @RequestParam("prompt") String prompt,
                                      HttpServletResponse response) throws IOException {
        LoginResponseDTO loginResponse = loginHelper.processGrantCode(code);
        Cookie cookie = new Cookie("accessToken", loginResponse.getAccessToken());
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // true si usas HTTPS
        cookie.setPath("/");
        cookie.setMaxAge(3600);
        cookie.setDomain("localhost");

        response.addCookie(cookie);

        // Redirige al frontend ya autenticado
        response.sendRedirect("http://localhost:3000/dashboard");
    }

    @GetMapping("/account-verification")
    public String verifyAccount(@RequestParam("id") String id) {
        return loginHelper.verifyAccount(id);
    }

    @PostMapping("/generate-reset-password-link")
    public String generateResetPasswordLink(@RequestParam String email) {
        return loginHelper.initiateResetPasswordLink(email);
    }

    @PutMapping("/change-password")
    public String changePassword(@RequestParam("token") String token, @RequestParam("new_password") String newPassword) {
        return loginHelper.changePasswordWithToken(token, newPassword);
    }

    @PutMapping("/logout-user")
    public String logoutUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return loginHelper.logout(email);
    }

    @PostMapping("/refresh-access-token")
    public LoginResponseDTO refreshAccessToken(@RequestParam("refresh_token") String refreshToken) {
        return loginHelper.refreshAccessToken(refreshToken);
    }
}
