package com.egg.entity;

import java.util.Date;
import java.util.List;

public class Dag {

    private Long id;
    private String dagId;
    private List<String> defaultArgs;
    private String description;
    private String scheduleInterval;
    private String filePath;
    private User createor;
    private Date createTime;
    private Date updateTime;
    private Integer status;

    public Dag() {
    }

    public Dag(String dagId, List<String> defaultArgs, String description, String scheduleInterval, String filePath, User createor, Date createTime, Date updateTime, Integer status) {
        this.dagId = dagId;
        this.defaultArgs = defaultArgs;
        this.description = description;
        this.scheduleInterval = scheduleInterval;
        this.filePath = filePath;
        this.createor = createor;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public String getDagId() {
        return dagId;
    }

    public void setDagId(String dagId) {
        this.dagId = dagId;
    }

    public List<String> getDefaultArgs() {
        return defaultArgs;
    }

    public void setDefaultArgs(List<String> defaultArgs) {
        this.defaultArgs = defaultArgs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScheduleInterval() {
        return scheduleInterval;
    }

    public void setScheduleInterval(String scheduleInterval) {
        this.scheduleInterval = scheduleInterval;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Dag{" +
                "id=" + id +
                ", dagId='" + dagId + '\'' +
                ", defaultArgs=" + defaultArgs +
                ", description='" + description + '\'' +
                ", scheduleInterval='" + scheduleInterval + '\'' +
                ", filePath='" + filePath + '\'' +
                ", createor=" + createor +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                '}';
    }
}