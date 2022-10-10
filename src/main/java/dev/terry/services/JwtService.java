package dev.terry.services;

public interface JwtService {

    String createJwtWithUsername(String username);
    boolean validateJwt(String jwt);
}
