package com.project.luma.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
