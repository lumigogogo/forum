package com.egg.controller;

import com.egg.annotations.LoginRequired;
import com.egg.dto.ForumResult;
import com.egg.entity.User;
import com.egg.dto.LogInPost;
import com.egg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/{userId}/detail", method = RequestMethod.GET)
    @ResponseBody
    @LoginRequired
    public ForumResult toIndex(@PathVariable("userId") long userId) {
        ForumResult result;
        User user = userService.getUserById(userId);
        result = new ForumResult<User>(true, user, "");
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ForumResult login(@RequestBody LogInPost logInPost) throws UnsupportedEncodingException {
        System.out.print(System.getProperty("user.dir"));
        ForumResult result;
        String name = logInPost.getName();
        String password = logInPost.getPassword();
        String token = userService.login(name, password);
        result = new ForumResult(true, token);
        return result;
    }
}
