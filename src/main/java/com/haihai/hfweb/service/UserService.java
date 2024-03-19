package com.haihai.hfweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haihai.hfweb.model.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

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

    /**
     * 根据标签搜索用户
     * @param tagList
     * @return
     */
    List<User> searchUserByTags(List<String> tagList);

    /**
     * 根据请求获得登陆用户
     * @param request
     * @return 当前用户
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 对用户信息进行更新
     * @param user 要修改的用户信息
     * @param loginUser 登陆的用户
     * @return 被修改后的用户信息
     */
    User updateUser(User user,User loginUser);

    /**
     * 判断是否为管理员
     * @param request
     * @return
     */
    Boolean isAdmin(HttpServletRequest request);

    /**
     * 判断是否为管理员
     * @param loginUser
     * @return
     */
    Boolean isAdmin(User loginUser);

}
