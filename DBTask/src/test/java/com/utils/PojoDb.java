package com.utils;

import java.util.Objects;

public class PojoDb {
    private String name;
    private String methodName;
    private String browser;
    private String env;
    private String startTime;
    private String endTime;
    private Integer statusId;
    private Long projectId;
    private Long sessionId;
    private Long id;
    private Long authorId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PojoDb pojoDb = (PojoDb) o;
        return Objects.equals(name, pojoDb.name) && Objects.equals(methodName, pojoDb.methodName) && Objects.equals(browser, pojoDb.browser) && Objects.equals(env, pojoDb.env) && Objects.equals(startTime, pojoDb.startTime) && Objects.equals(endTime, pojoDb.endTime) && Objects.equals(statusId, pojoDb.statusId) && Objects.equals(projectId, pojoDb.projectId) && Objects.equals(sessionId, pojoDb.sessionId) && Objects.equals(id, pojoDb.id) && Objects.equals(authorId, pojoDb.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, methodName, browser, env, startTime, endTime, statusId, projectId, sessionId, id, authorId);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public PojoDb(String name,
                  String methodName,
                  String browser,
                  String env,
                  String startTime,
                  String endTime,
                  Integer statusId,
                  Long projectId,
                  Long sessionId,
                  Long id,
                  Long authorId) {
        this.name = name;
        this.methodName = methodName;
        this.browser = browser;
        this.env = env;
        this.startTime = startTime;
        this.endTime = endTime;
        this.statusId = statusId;
        this.projectId = projectId;
        this.sessionId = sessionId;
        this.id = id;
        this.authorId = authorId;
    }


    public String getName() {
        return name;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public String getMethodName() {
        return methodName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEnv() {
        return env;
    }

    public String getBrowser() {
        return browser;
    }

    public Long getId() {
        return id;
    }

    public Long getAuthorId() {
        return authorId;
    }

}
