package com.lmp.unmsm.auth.model;

import java.time.LocalDateTime;

public class LoginResponseDTO {
    private String accessToken;
    private String refreshToken;
    private LocalDateTime expirationTime;
    private String email;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String accessToken, String refreshToken, LocalDateTime expirationTime, String email) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expirationTime = expirationTime;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }
}
