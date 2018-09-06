package com.egg.entity;

public class User {

    private String name;
    private String email;
    private String password;
    private Long phone;
    private Short status;
    private String title;
    private Long userId;

    public User() {

    }

    public User(String name, String email, String password,
                Long phone, Short status, String title) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", status=" + status +
                ", title='" + title + '\'' +
                '}';
    }
}
