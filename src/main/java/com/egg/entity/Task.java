package com.egg.entity;

import java.util.Date;
import java.util.List;

public class Task {

    private Long id;
    private String taskId;
    private String bashCommend;
    private String hqlScript;
    private List<String> upStream;
    private List<String> downStream;
    private String description;
    private Long dagId;
    private User createor;
    private Date createTime;
    private Date updateTime;
    private Integer status;
    private Integer type;

    public Task() {
    }

    public Task(String taskId, String bashCommend, String hqlScript, List<String> upStream, List<String> downStream, String description, Long dagId, User createor, Date createTime, Date updateTime, Integer status, Integer type) {
        this.taskId = taskId;
        this.bashCommend = bashCommend;
        this.hqlScript = hqlScript;
        this.upStream = upStream;
        this.downStream = downStream;
        this.description = description;
        this.dagId = dagId;
        this.createor = createor;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.type = type;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getBashCommend() {
        return bashCommend;
    }

    public void setBashCommend(String bashCommend) {
        this.bashCommend = bashCommend;
    }

    public String getHqlScript() {
        return hqlScript;
    }

    public void setHqlScript(String hqlScript) {
        this.hqlScript = hqlScript;
    }

    public List<String> getUpStream() {
        return upStream;
    }

    public void setUpStream(List<String> upStream) {
        this.upStream = upStream;
    }

    public List<String> getDownStream() {
        return downStream;
    }

    public void setDownStream(List<String> downStream) {
        this.downStream = downStream;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDagId() {
        return dagId;
    }

    public void setDagId(Long dagId) {
        this.dagId = dagId;
    }

    public User getCreateor() {
        return createor;
    }

    public void setCreateor(User createor) {
        this.createor = createor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", bashCommend='" + bashCommend + '\'' +
                ", hqlScript='" + hqlScript + '\'' +
                ", upStream=" + upStream +
                ", downStream=" + downStream +
                ", description='" + description + '\'' +
                ", dagId=" + dagId +
                ", createor=" + createor +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
