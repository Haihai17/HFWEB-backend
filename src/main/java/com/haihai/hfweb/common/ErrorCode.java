package com.haihai.hfweb.common;

public enum ErrorCode {
    PARAMS_ERROR(40000, "参数错误", "参数错误"),
    NULL_ERROR(40001, "数据为空", "数据为空"),
    NO_AUTH(40003, "无权限", "无权限"),
    NOT_LOGIN(40004, "未登录", "未登录"),

    SYSTEM_ERROR(50000, "系统错误", "系统错误"),
    ;


    private final int code;
    /**
     * 状态码信息
     */
    private final String message;
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
