package com.project.luma.dto.auth;

public record UserProfileResponse(
        Long id,
        String username,
        String name) {
}
