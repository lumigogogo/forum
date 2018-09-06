package com.egg.exceptionHandler;

import com.egg.dto.ForumResult;
import com.egg.exception.JwtException;
import com.egg.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ForumResult handleExp(Exception e) {
        if (e instanceof UserException) {
            return new ForumResult(false, e.getMessage());
        } else if (e instanceof JwtException) {
            return new ForumResult(false, e.getMessage());
        } else {
            return new ForumResult(false, "服务器被UFO偷走啦！");
        }
    }
}
