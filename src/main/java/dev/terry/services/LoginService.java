package dev.terry.services;

import dev.terry.dtos.LoginCredentials;

public interface LoginService {
    String authenticateUser(LoginCredentials loginCredentials);
}
