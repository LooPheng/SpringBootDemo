package com.example.demo.domain;

/**
 * @Description: http请求返回的最外层对象
 * @Auther: LF
 * @Date: 2018/7/13 22:23
 */
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
