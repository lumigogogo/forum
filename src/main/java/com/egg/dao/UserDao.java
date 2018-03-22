package com.egg.dao;

import com.egg.entity.User;


public interface UserDao {
    /**
     * 查询用户详情 role-all
     * @param userId
     * @return
     */
    User getUser(Long userId);

    /**
     * 修改用户信息 role-owner & superAdmin
     * @param userId
     * @return
     */
    boolean updateUser(Long userId, User user);

    /**
     * 修改用户状态 role-superAdmin
     * @param userId
     * @param state
     * @return
     */
    boolean updateUserState(Long userId, Short state);

    /**
     * 删除用户 role-superAdmin
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);

    /**
     * 创建用户 role-superAdmin
     * @param user
     * @return
     */
    boolean createUser(User user);

}
