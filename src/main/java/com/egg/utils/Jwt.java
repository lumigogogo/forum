package com.egg.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.egg.dao.UserDao;
import com.egg.dao.cache.RedisDao;
import com.egg.entity.User;
import com.egg.exception.JwtException;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;

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

    public static void verifyJwt(String token) throws JwtException {
        try {
            Algorithm al = Algorithm.HMAC256(SECRETKEY);
            JWTVerifier verifier = JWT.require(al).build();
            DecodedJWT jwt = verifier.verify(token);
            long userId = jwt.getClaim("userId").asLong();
            // 检查该用户ID对应的token是否被缓存，避免伪造token
            String cacheToken = redisDao.getToken(userId);
            if (cacheToken == null || !cacheToken.equals(token)) {
                Log4j.error("token异常");
                throw new JwtException("token异常");
            }
        } catch (Exception e) {
            Log4j.error("验证失败");
            throw new JwtException("验证失败");
        }
    }

    public static User getUser(String token) {
        try {
            Algorithm al = Algorithm.HMAC256(SECRETKEY);
            JWTVerifier verifier = JWT.require(al).build();
            DecodedJWT jwt = verifier.verify(token);
            long userId = jwt.getClaim("userId").asLong();
            // 没有校验user是否存在，请确保调用此方法前先调用 Jwt.verifyJwt(token) 验证用户.
            UserDao userDao = (UserDao) SpringTool.getBean("userDao");
            return userDao.getUser(userId);
        } catch (Exception e) {
            Log4j.error("解析token失败");
            throw new JwtException("解析token失败");
        }
    }

    public static void main(String[] args) {
        try {
            String token = createJwt(1001);
            System.out.print(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
