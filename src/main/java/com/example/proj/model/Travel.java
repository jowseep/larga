package com.example.proj.model;

//this model is basically a template which helps the bus operator add or modify the current available routes
public class Travel {
    private int id;
    private String departure;
    private String arrival;
    private String bus_company;
    private String bus_unit;
    private float price;
    private String time;

    public Travel() {}

    public Travel(int id, String departure, String arrival, String bus_company, String bus_unit, float price, String time) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.bus_company = bus_company;
        this.bus_unit = bus_unit;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getBus_company() {
        return bus_company;
    }

    public void setBus_company(String bus_company) {
        this.bus_company = bus_company;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBus_unit() {
        return bus_unit;
    }

    public void setBus_unit(String bus_unit) {
        this.bus_unit = bus_unit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
