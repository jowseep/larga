package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.example.proj.model.Booking;

public class BookingList implements SessionAware{

    private String error;
    private Integer user_id;
    private Map<String, Object> userSession;
    ArrayList<Booking> booking = new ArrayList<Booking>();
    private String booking_reference;

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

    public String lookBooking() throws SQLException {
        user_id =  (Integer) userSession.get("user_id");
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "SELECT * FROM userinfo INNER JOIN booking ON userinfo.id = booking.user_id INNER JOIN travel ON booking.travel_id = travel.id WHERE userinfo.id='"+user_id+"' && booking.status='active'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){  
                    Booking bookings =new Booking();
                    bookings.setBooking_reference(rs.getInt(8));
                    bookings.setDeparture_city(rs.getString(20));   
                    bookings.setArrival_city(rs.getString(21));
                    bookings.setTravel_date(rs.getString(14));
                    bookings.setTravel_time(rs.getString(25));
                    bookings.setBooking_date(rs.getString(16)); 
                    bookings.setBus_operator(rs.getString(21));
                    bookings.setSeat(rs.getString(13));
                    booking.add(bookings);
                } 
            }
         } catch (Exception e) {
             error = e.toString();
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return "success";
    }

    public String guestBooking() throws SQLException {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "select * from booking inner join travel on booking.travel_id = travel.id where booking.user_id IS NULL && booking.status='active'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){  
                    Booking bookings =new Booking();
                    bookings.setBooking_reference(rs.getInt(1));
                    bookings.setFirstName(rs.getString(3));
                    bookings.setLastName(rs.getString(4));
                    bookings.setEmail(rs.getString(10));
                    bookings.setDeparture_city(rs.getString(13));   
                    bookings.setArrival_city(rs.getString(14));
                    bookings.setTravel_date(rs.getString(7));
                    bookings.setTravel_time(rs.getString(18));
                    bookings.setBooking_date(rs.getString(9)); 
                    bookings.setBus_operator(rs.getString(15));
                    bookings.setSeat(rs.getString(6));
                    booking.add(bookings);
                } 
            }
         } catch (Exception e) {
             error = e.toString();
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return "success";
    }

    public String userBooking() throws SQLException {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "SELECT * FROM userinfo INNER JOIN booking ON userinfo.id = booking.user_id INNER JOIN travel ON booking.travel_id = travel.id WHERE booking.user_id IS NOT NULL && booking.status='active'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while(rs.next()){  
                    Booking bookings =new Booking();
                    bookings.setBooking_reference(rs.getInt(8));
                    bookings.setFirstName(rs.getString(2));
                    bookings.setLastName(rs.getString(3));
                    bookings.setEmail(rs.getString(4));
                    bookings.setDeparture_city(rs.getString(20));   
                    bookings.setArrival_city(rs.getString(21));
                    bookings.setTravel_date(rs.getString(14));
                    bookings.setTravel_time(rs.getString(25));
                    bookings.setBooking_date(rs.getString(16)); 
                    bookings.setBus_operator(rs.getString(22));
                    bookings.setSeat(rs.getString(13));
                    booking.add(bookings);
                } 
            }
         } catch (Exception e) {
             error = e.toString();
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return "success";
    }

    public String cancelBooking() throws SQLException{
        Connection connection = connectToDB();
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "UPDATE booking SET booking.status = 'inactive' WHERE booking.id = '"+booking_reference+"'";
                statement.executeUpdate(sql);
            } else {
                error = "DB connection failed";
                return "fail";
            }
         } catch (Exception e) {
             error = e.toString();
             return "fail"; 
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
        return "success";
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Booking> getBooking() {
        return booking;
    }

    public void setBooking(ArrayList<Booking> booking) {
        this.booking = booking;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBooking_reference() {
        return booking_reference;
    }

    public void setBooking_reference(String booking_reference) {
        this.booking_reference = booking_reference;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
}
