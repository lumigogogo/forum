package com.egg.service.impl;

import com.egg.dao.UserDao;
import com.egg.entity.User;
import com.egg.exception.UserException;
import com.egg.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) throws UserException{
        User user = null;
        user = userDao.getUser(userId);
        if (user == null){
            throw new UserException("用户不存在");
        }
        return user;
    }

    public boolean modifyUser(long userId, Map data) {
        User user = null;
        user = userDao.getUser(userId);
        if (user == null){
        throw new UserException("用户不存在");
    }


        return false;
}

    public long login(long phone, String password) {
        User user = null;
        user = userDao.login(phone, password);
        if (user == null){
            throw new UserException("用户名或者密码错误！");
        }
        return user.getUser_id();
    }
}
