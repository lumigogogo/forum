package com.egg.service.impl;

import com.egg.dao.UserDao;
import com.egg.entity.User;
import com.egg.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public User getUserById(Long userId) {
        return userDao.getUser(userId);
    }
}
