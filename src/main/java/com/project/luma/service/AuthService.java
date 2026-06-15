package com.project.luma.service;

import com.project.luma.dto.auth.AuthResponse;
import com.project.luma.dto.auth.LoginRequest;
import com.project.luma.dto.auth.SignupRequest;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);
}
