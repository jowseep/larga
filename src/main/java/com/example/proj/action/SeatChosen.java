package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.proj.model.Travel;

public class SeatChosen {

    private String seatchosen;
    private Date date;
    private String id;
    String error = "random";
    Travel travel;
    private String payment_method;
    private List<String> payment;

    public SeatChosen() {
        payment = new ArrayList<String>();
        payment.add("GCash");
        payment.add("PayMaya");
        payment.add("Card");
        payment.add("Cash");
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

    public List<String> getPayment() {
        return payment;
    }

    public void setPayment(List<String> payment) {
        this.payment = payment;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

}
