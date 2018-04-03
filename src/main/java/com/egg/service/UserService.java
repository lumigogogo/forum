package com.egg.service;

import com.egg.entity.User;

import java.util.Map;

public interface UserService {

    User getUserById(Long userId);

    boolean modifyUser(long userId, Map data);

    long login(long phone, String password);
}
