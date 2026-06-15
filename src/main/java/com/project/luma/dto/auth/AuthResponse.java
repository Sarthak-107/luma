package com.project.luma.dto.auth;

public record AuthResponse(String token, UserProfileResponse user) {
}
