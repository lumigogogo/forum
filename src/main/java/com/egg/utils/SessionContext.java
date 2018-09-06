package com.egg.utils;

import com.egg.entity.User;

public class SessionContext {

    private static final ThreadLocal<User> threadLocal = new ThreadLocal<User>();

    public static void addSession(User user) {
        if (user != null) {
            threadLocal.set(user);
        } else {
            Log4j.debug("user is null");
        }
    }

    public static User getSession() {
        return threadLocal.get();
    }
}
