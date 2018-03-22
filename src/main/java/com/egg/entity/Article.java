package com.egg.entity;

import java.util.Date;

public class Article {

    private String title;
    private Short state;
    private Date craeteTime;
    private String body;
    private Integer commentNum;
    private Date updateTime;

    public Article() {

    }

    public Article(String title, Short state, Date craeteTime, String body, Integer commentNum, Date updateTime) {
        this.title = title;
        this.state = state;
        this.craeteTime = craeteTime;
        this.body = body;
        this.commentNum = commentNum;
        this.updateTime = updateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getCraeteTime() {
        return craeteTime;
    }

    public void setCraeteTime(Date craeteTime) {
        this.craeteTime = craeteTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", state=" + state +
                ", craeteTime=" + craeteTime +
                ", body='" + body + '\'' +
                ", commentNum=" + commentNum +
                ", updateTime=" + updateTime +
                '}';
    }
}
