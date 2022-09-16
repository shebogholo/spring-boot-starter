package com.shebogholo.starter.auth;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {}