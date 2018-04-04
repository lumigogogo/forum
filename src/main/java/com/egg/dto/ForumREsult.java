package com.egg.dto;

public class ForumREsult<T> {

    private boolean success;
    private T data;
    private String error;
    private String jwt;
    private int code;

    public ForumREsult(boolean success, T data){
        this.success = success;
        this.data = data;
    }

    public ForumREsult(boolean success, String error){
        this.success = success;
        this.error = error;
    }

    public ForumREsult(boolean success, String jwt, int code){
        this.success = success;
        this.jwt = jwt;
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getJwt() {
        return jwt;
    }

    public int getCode() {
        return code;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ForumREsult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                ", jwt='" + jwt + '\'' +
                ", code=" + code +
                '}';
    }
}
