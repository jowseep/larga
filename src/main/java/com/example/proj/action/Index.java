package com.example.proj.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport implements SessionAware {

    private String token;
    private Map<String, Object> userSession;

    public String execute() {
        token = (String) userSession.get ("token");
        if(token!=null) {
            return "loggedin";
        } else {
            return "notloggedin";
        }
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
