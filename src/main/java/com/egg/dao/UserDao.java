package com.egg.dao;

import com.egg.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;


public interface UserDao {
    /**
     * 查询用户详情 role-all
     *
     * @param userId 用户id
     * @return 用户对象
     */
    User getUser(Long userId);

    /**
     * 用户登入验证
     *
     * @param name     用户账号名
     * @param password 用户密码
     * @return 用户对象
     */
    User login(@Param("name") String name, @Param("password") String password);

    /**
     * 修改用户信息 role-owner & superAdmin
     *
     * @param userId 用户id
     * @return boolean
     */
    boolean updateUser(Long userId, Map data);

    /**
     * 修改用户状态 role-superAdmin
     *
     * @param userId 用户id
     * @param status 用户状态
     * @return boolean
     */
    boolean updateUserState(Long userId, Short status);

    /**
     * 删除用户 role-superAdmin
     *
     * @param userId 用户id
     * @return boolean
     */
    boolean deleteUser(Long userId);

    /**
     * 创建用户 role-superAdmin
     *
     * @param user 用户对象
     * @return boolean
     */
    boolean createUser(User user);

}
