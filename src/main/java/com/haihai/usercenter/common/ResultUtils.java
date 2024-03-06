package com.haihai.usercenter.common;

/**
 * 返回工具类
 */
public class ResultUtils {
        /**
         * 成功
         * @param data
         * @return
         * @param <T>
         */
        public static <T> BaseResponse<T> success(T data) {
            return new BaseResponse<>(0, data,"ok","");
        }

        public static <T> BaseResponse<T> success(T data, String message) {
            return new BaseResponse<>(0, data, message,"");
        }

        /**
         * 失败
         * @param errorCode
         * @return
         * @param <T>
         */
        public static <T> BaseResponse<T> error(ErrorCode errorCode) {
            return new BaseResponse<>(errorCode.getCode(), null, errorCode.getMessage(),errorCode.getDescription());
        }

        public static <T> BaseResponse<T> error(ErrorCode errorCode,String message, String description) {
            return new BaseResponse<>(errorCode.getCode(), null, message,description);
        }
        public static <T> BaseResponse<T> error(ErrorCode errorCode,String message) {
            return new BaseResponse<>(errorCode.getCode(), null, message,"");
        }

        public static <T> BaseResponse<T> error(int code, T data, String message) {
            return new BaseResponse<>(code, data, message,"");
        }
        public static <T> BaseResponse<T> error(int code, String message,String description) {
            return new BaseResponse<>(code, null, message,description);
        }

}
