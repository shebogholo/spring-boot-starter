package com.shebogholo.starter.auth;

public record LoginRequest(
        String email,
        String password
) {}