package com.egg.aop;

import com.egg.entity.User;
import com.egg.utils.Jwt;
import com.egg.utils.SessionContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Aspect
@Component
public class LoginAspect {

    private static final String SECRETKEY = "!@#$%^&*/-=";

    private User user;

    @Autowired
    private HttpServletRequest request;

    @Pointcut(value = "@annotation(com.egg.annotations.LoginRequired)")
    public void loginPoint() {

    }

    @Before("loginPoint()")
    public void before() throws UnsupportedEncodingException {
        String token = request.getHeader("authorization");
        Jwt.verifyJwt(token);
        SessionContext.addSession(Jwt.getUser(token));
    }
}
