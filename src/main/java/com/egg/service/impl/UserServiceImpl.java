package com.egg.service.impl;

import com.egg.annotations.LoginRequired;
import com.egg.dao.UserDao;
import com.egg.dao.cache.RedisDao;
import com.egg.entity.User;
import com.egg.exception.UserException;
import com.egg.service.UserService;
import com.egg.utils.Jwt;
import com.egg.utils.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Autowired
    private RedisDao redisDao;

    @LoginRequired
    public User getUserById(Long userId) throws UserException {
        User user = null;
        User u = SessionContext.getSession();
        user = userDao.getUser(userId);
        if (user == null) {
            throw new UserException("用户不存在");
        }
        return user;
    }

    public boolean modifyUser(long userId, Map data) {
        User user = null;
        user = userDao.getUser(userId);
        if (user == null) {
            throw new UserException("用户不存在");
        }
        return false;
    }

    public String login(String name, String password) throws UnsupportedEncodingException {
        User user = null;
        user = userDao.login(name, password);
        if (user == null) {
            throw new UserException("用户名或者密码错误！");
        }
        String token = Jwt.createJwt(user.getUserId());
        redisDao.putToken(user.getUserId(), token);
        return token;
    }
}
