package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class Confirm implements SessionAware{

    public String error;
    private String firstName;
    private String lastName;
    private String email;
    private Integer user_id;
    private int id;
    private String date;
    private String seatchosen;
    private String dateToday;
    private String token;
    private Map<String, Object> userSession;
    private String username;
    
    public String execute() throws SQLException {
        token = (String) userSession.get("token");
        if(token!=null) {
            if(createBookingUser()) {
                return "success";
            } else {
                return "fail";
            }
        } else {
            if(createBookingGuest()) {
                return "success";
            } else {
                return "fail";
            }
        }
    }

    public Connection connectToDB() throws SQLException {
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            return connection;
        } catch (Exception e) {
            error = e.toString();
        }

        return null;
    }

    public boolean createBookingUser() throws SQLException {
        String thedateFormat = "yyyy-MM-dd"; 
        Calendar calendar = Calendar.getInstance();     
        SimpleDateFormat dateFormat = new SimpleDateFormat(thedateFormat);       
        dateToday = dateFormat.format(calendar.getTime());
        user_id = (Integer) userSession.get("user_id");
        Connection connection = connectToDB();
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO booking(user_id, travel_id, seat_no, travel_date, booking_date) VALUES('"+user_id+"','"+id+"','"+seatchosen+"','"+date+"','"+dateToday+"')";
                statement.executeUpdate(sql);
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public boolean createBookingGuest() throws SQLException {
        String date = "yyyy-MM-dd"; 
        Calendar calendar = Calendar.getInstance();     
        SimpleDateFormat dateFormat = new SimpleDateFormat(date);       
        dateToday = dateFormat.format(calendar.getTime());
        Connection connection = connectToDB();
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO booking(firstName, lastName, travel_id, seat_no, travel_date, booking_date, email) VALUES('"+firstName+"','"+lastName+"','"+id+"','"+seatchosen+"','"+date+"','"+dateToday+"','"+email+"')";
                statement.executeUpdate(sql);
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeatchosen() {
        return seatchosen;
    }

    public void setSeatchosen(String seatchosen) {
        this.seatchosen = seatchosen;
    }

    public String getDateToday() {
        return dateToday;
    }

    public void setDateToday(String dateToday) {
        this.dateToday = dateToday;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
}
