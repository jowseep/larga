package com.example.proj.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class Seat implements SessionAware {

    private String id;
    private Date date;
    private String token;
    private Map<String, Object> userSession;

    public String execute() {
        token = (String) userSession.get("token");
        return "success";
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }    

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
}
