package com.egg.service;

import com.egg.entity.User;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface UserService {

    User getUserById(Long userId);

    boolean modifyUser(long userId, Map data);

    String login(long phone, String password) throws UnsupportedEncodingException;
}
