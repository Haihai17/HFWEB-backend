package com.haihai.usercenter.model.request;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author haihai
 */
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -222954329923529976L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;


    public String getPlanetCode() {
        return planetCode;
    }

    public void setPlanetCode(String planetCode) {
        this.planetCode = planetCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
