package com.erkal.todospring.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.erkal.todospring.Entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import java.util.Date;



@Service
public class JwtService {

    private final static  String secretKey= "secretkey";
    private final Algorithm algorithm = Algorithm.HMAC512(secretKey);


    public String generateToken(String email){
        String token = JWT
                .create()
                .withSubject(email)
                .sign(algorithm);
        return token;
    }

    public String getTokenEmail(String token){
        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(token);
        return decodedJWT.getSubject();
    }

}
