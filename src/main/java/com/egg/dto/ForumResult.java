package com.egg.dto;

public class ForumResult<T> {

    private boolean success;
    private T data;
    private String msg;
    private int code;

    public ForumResult(boolean success, T data, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    public ForumResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ForumResult{" +
                "success=" + success +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}
