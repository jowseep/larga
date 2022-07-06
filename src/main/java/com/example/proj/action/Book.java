package com.example.proj.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Book {

    private List<String> cities;
    private String departure_city;
    private String arrival_city;
    private Date date;

    public String execute() {
        return "success";
    }

    public Book() {
        cities = new ArrayList<String>();
        cities.add("Carmen");
        cities.add("Davao City");
        cities.add("Digos City");
        cities.add("Panabo City");
        cities.add("Sta. Cruz");
        cities.add("Tagum City");
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTodayDate(){
		return new Date();
	}
}