package com.egg.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Jwt {

    private static final String SECRETKEY = "!@#$%^&*/-=";

    public static String createJwt(long userId) throws UnsupportedEncodingException {
        Algorithm al = Algorithm.HMAC256(SECRETKEY);
        return JWT.create()
                .withClaim("userId", userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + 600000))
                .sign(al);
    }

    public static void verifyJwt(String token) throws UnsupportedEncodingException {
        try{
            Algorithm al = Algorithm.HMAC256(SECRETKEY);
            JWTVerifier verifier = JWT.require(al).build();
            DecodedJWT jwt = verifier.verify(token);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (JWTVerificationException e){
            e.printStackTrace();
            System.out.print("校验失败");
        }
    }
}
