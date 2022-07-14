package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import com.example.proj.model.Travel;

import org.apache.struts2.interceptor.SessionAware;

public class SeatChosen implements SessionAware {

    private String seatchosen;
    private Date date;
    private String id;
    String error = "random";
    Travel travel;
    private String token;
    private Map<String, Object> userSession;

    public String bookingOption() {
        token = (String) userSession.get("token");
        if(token!=null) {
            return "success";
        } else {
            return "login";
        }
    }

    public Connection connectToDB() throws SQLException {
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            return connection;
        } catch (Exception e) {
            error = e.toString();
        }

        return null;
    }

    public String execute() throws Exception{
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {

            if (connection != null) {
                String sql = "SELECT * FROM travel WHERE id = "+getId()+"";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Travel travels=new Travel();
                    travels.setDeparture(rs.getString(2));   
                    travels.setArrival(rs.getString(3));
                    travels.setBus_company(rs.getString(4));
                    travels.setPrice(rs.getFloat(6));
                    travels.setTime(rs.getString(7));  
                    setTravel(travels);
                }

            }
        } catch (Exception e) {
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
        return "success";
    }

    public String getSeatchosen() {
        return seatchosen;
    }

    public void setSeatchosen(String seatchosen) {
        this.seatchosen = seatchosen;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
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
