package com.haihai.usercenter.model.request;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -3430664037976053371L;
    private String userAccount;

    private String userPassword;

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
}
