package com.egg.entity;

import java.util.Date;

public class Comment {

    private Short state;
    private String body;
    private Date createTime;
    private Long commentLevel;
    private Date updateTime;

    public Comment(){

    }

    public Comment(Short state, String body, Date createTime, Long commentLevel, Date updateTime) {
        this.state = state;
        this.body = body;
        this.createTime = createTime;
        this.commentLevel = commentLevel;
        this.updateTime = updateTime;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Long commentLevel) {
        this.commentLevel = commentLevel;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "state=" + state +
                ", body='" + body + '\'' +
                ", createTime=" + createTime +
                ", commentLevel=" + commentLevel +
                ", updateTime=" + updateTime +
                '}';
    }
}
