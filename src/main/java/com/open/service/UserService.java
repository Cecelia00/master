package com.open.service;


import com.open.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 用户注册添加
     * @param user
     */
    void addUser(User user);


    /**
     * 用户登录
     * @param email
     * @param password
     * @return
     */
    User login(String email, String password);

    /**
     * 修改密码
     * @param email 用户邮箱
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword( String email, String oldPassword, String newPassword);

    void changeAvatar(Integer id, String username, String avatar);




}
