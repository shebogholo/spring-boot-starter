package com.shebogholo.starter.user;

public record UserRequest(
        String firstName,
        String lastName,
        String email
) {}
