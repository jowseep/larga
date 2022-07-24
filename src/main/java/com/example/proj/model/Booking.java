package com.example.proj.model;

//this model contains all the user's booking information after reserving a seat
public class Booking {
    private int booking_reference;
    private String firstName;
    private String lastName;
    private String email;
    private String departure_city;
    private String arrival_city;
    private String travel_date;
    private String travel_time;
    private String booking_date;
    private String bus_operator;
    private String seat;
    

    public Booking() {}

    public Booking(int booking_reference, String firstName, String lastName, String email, String departure_city, String arrival_city, String travel_date, String travel_time, String booking_date, String bus_operator, String seat) {
        this.booking_reference = booking_reference;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email; 
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.travel_date = travel_date;
        this.travel_time = travel_time;
        this.booking_date = booking_date;
        this.bus_operator = bus_operator;
        this.seat = seat;
    }

    public Booking(int booking_reference, String departure_city, String arrival_city, String travel_date, String travel_time, String booking_date, String bus_operator, String seat) {
        this.booking_reference = booking_reference;
        this.departure_city = departure_city;
        this.arrival_city = arrival_city;
        this.travel_date = travel_date;
        this.travel_time = travel_time;
        this.booking_date = booking_date;
        this.bus_operator = bus_operator;
        this.seat = seat;
    }


    public int getBooking_reference() {
        return booking_reference;
    }

    public void setBooking_reference(int booking_reference) {
        this.booking_reference = booking_reference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(String travel_date) {
        this.travel_date = travel_date;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public String getBus_operator() {
        return bus_operator;
    }

    public void setBus_operator(String bus_operator) {
        this.bus_operator = bus_operator;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

}