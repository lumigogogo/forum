package com.egg.entity;

public class User {

    private String name;
    private String nickName;
    private String password;
    private Long phone;
    private Short state;
    private String title;

    public User(){

    }

    public User(String name, String nickName, String password,
                Long phone, Short state, String title){
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.phone = phone;
        this.state = state;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", state=" + state +
                ", title='" + title + '\'' +
                '}';
    }
}
