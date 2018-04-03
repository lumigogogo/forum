package com.egg.dto;

public class ForumREsult<T> {

    private boolean success;
    private T data;
    private String error;

    public ForumREsult(boolean success, T data){
        this.success = success;
        this.data = data;
    }

    public ForumREsult(boolean success, String error){
        this.success = success;
        this.error = error;
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

    @Override
    public String toString() {
        return "ForumREsult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
