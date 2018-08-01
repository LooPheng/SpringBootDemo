package com.example.demo.enums;

/**
 * @Description:
 * @Auther: LF
 * @Date: 2018/7/15 15:57
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    UNIVERSITY(666, "你上大学了")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
