package com.egg.controller;

import com.egg.dto.ForumREsult;
import com.egg.entity.User;
import com.egg.exception.UserException;
import com.egg.pojo.LogInPoJo;
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
    public ForumREsult toIndex(@PathVariable("userId") long userId){
        ForumREsult result;
        try{
            User user = userService.getUserById(userId);
            result = new ForumREsult<User>(true, user);
        }catch (UserException e){
            result = new ForumREsult(false, e.getMessage());
        }catch (Exception e1){
            result = new ForumREsult(false, e1.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ForumREsult login(@RequestBody LogInPoJo logInPoJo){
        ForumREsult result;
        Long phone = logInPoJo.getPhone();
        String password = logInPoJo.getPassword();
        try{
            String token = userService.login(phone, password);
            result = new ForumREsult(true, token, 0);
        } catch (UserException e){
            result = new ForumREsult(false, e.getMessage());
        } catch (UnsupportedEncodingException e) {
            result = new ForumREsult(false, e.getMessage());
        }
        return result;
    }
}
