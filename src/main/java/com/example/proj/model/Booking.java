package com.example.proj.model;

//this model contains all the user's booking information after reserving a seat
public class Booking {
    private int id;
    private int user_id;
    private String seat_no;
    private String travel_date;
    private String payment_method;
    private String booking_date;

    public Booking() {}

    public Booking(int id, int user_id, String seat_no, String travel_date, String payment_method, String booking_date) {
        this.id = id;
        this.user_id = user_id;
        this.seat_no = seat_no;
        this.travel_date = travel_date;
        this.payment_method = payment_method;
        this.booking_date = booking_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSeat_no() {
        return seat_no;
    }

    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    public String getTravel_date() {
        return travel_date;
    }

    public void setTravel_date(String travel_date) {
        this.travel_date = travel_date;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    
}
