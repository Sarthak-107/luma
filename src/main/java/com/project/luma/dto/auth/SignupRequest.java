package com.project.luma.dto.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
