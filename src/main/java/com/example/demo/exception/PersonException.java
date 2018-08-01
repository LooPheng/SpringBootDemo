package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * @Description:
 * @Auther: LF
 * @Date: 2018/7/15 15:39
 */
public class PersonException extends RuntimeException {

    private Integer code;

    public PersonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
