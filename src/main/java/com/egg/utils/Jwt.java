package com.egg.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.egg.dao.cache.RedisDao;
import com.egg.exception.JwtException;

import java.io.UnsupportedEncodingException;
import java.util.Date;

public class Jwt {

    private static final String SECRETKEY = "!@#$%^&*/-=";

    private static final RedisDao redisDao = new RedisDao("localhost", 6379);

    public static String createJwt(long userId) throws UnsupportedEncodingException {
        Algorithm al = Algorithm.HMAC256(SECRETKEY);
        return JWT.create()
                .withIssuer("king")
                .withSubject("user")
                .withClaim("userId", userId)
                .withExpiresAt(new Date(System.currentTimeMillis() + 600000))
                .sign(al);
    }

    public static void verifyJwt(String token) throws UnsupportedEncodingException, JwtException {
        try{
            Algorithm al = Algorithm.HMAC256(SECRETKEY);
            JWTVerifier verifier = JWT.require(al).build();
            DecodedJWT jwt = verifier.verify(token);
            long userId = jwt.getClaim("userId").asLong();
            // 检查该用户ID对应的token是否被缓存，避免伪造token
            String cacheToken = redisDao.getToken(userId);
            if(cacheToken==null || !cacheToken.equals(token)){
                throw new JwtException("token异常");
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        } catch (JWTVerificationException e){
            e.printStackTrace();
            throw new JwtException("验证失败");
        }
    }

    public static void main(String[] args){
        try {
            String token = createJwt(1001);
            System.out.print(token);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
