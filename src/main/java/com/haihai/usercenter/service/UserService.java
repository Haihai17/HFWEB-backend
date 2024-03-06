package com.haihai.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haihai.usercenter.model.User;
import jakarta.servlet.http.HttpServletRequest;

/**
* @author haihai
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-02-20 22:33:32
*/
public interface UserService extends IService<User> {



    /**
     * 注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword,String planetCode);

    /**
     * 用户登陆
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param request
     * @return 用户信息（脱敏）
     */
    User doLogin(String userAccount, String userPassword,HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);
}
