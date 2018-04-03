package com.egg.controller;

import com.egg.dto.ForumREsult;
import com.egg.entity.User;
import com.egg.exception.UserException;
import com.egg.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public ForumREsult login(HttpServletRequest request){
        ForumREsult result;
        long phone = Long.parseLong(request.getParameter("phone"));
        String password = request.getParameter("password");
        long userId = userService.login(phone, password);
        result = new ForumREsult<Long>(true, userId);
        return result;
    }
}
