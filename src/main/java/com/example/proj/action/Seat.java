package com.example.proj.action;

import java.util.Date;

public class Seat {

    private String id;
    private Date date;

    public String execute() {
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
}
