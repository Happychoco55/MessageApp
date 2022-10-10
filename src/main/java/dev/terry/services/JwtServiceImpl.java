package dev.terry.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService{

    private Algorithm algorithm = Algorithm.HMAC256("this is our super secret string for Team Titans");

    @Override
    public String createJwtWithUsername(String username) {
        String jwt = JWT.create().withClaim("username",username).sign(algorithm);
        return jwt;
    }

    @Override
    public boolean validateJwt(String jwt) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        try{
            verifier.verify(jwt);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
