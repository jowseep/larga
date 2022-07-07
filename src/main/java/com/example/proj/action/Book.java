package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.proj.model.Travel;

import java.util.Date;

public class Book {

    private List<String> cities;
    ArrayList<Travel> travel = new ArrayList<Travel>();
    Travel travelFound;
    public String departure_city;
    public String arrival_city;
    private int id;
    private Date date;
    String error = "random";

    public String execute() {
        return "success";
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

    public String result() throws Exception {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {

            if (connection != null) {
                String sql = "SELECT * FROM travel WHERE departure = '"+departure_city+"' && arrival = '"+arrival_city+"'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Travel travels=new Travel();
                    travels.setId(rs.getInt(1));
                    travels.setDeparture(rs.getString(2));   
                    travels.setArrival(rs.getString(3));
                    travels.setBus_company(rs.getString(4));
                    travels.setPrice(rs.getFloat(6));
                    travels.setTime(rs.getString(7));  
                    travel.add(travels);
                }

            }
        } catch (Exception e) {
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

        return "success";

    }

    public String seats() throws Exception{
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {

            if (connection != null) {
                String sql = "SELECT * FROM travel WHERE id = "+id+"";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Travel travels=new Travel();
                    travels.setDeparture(rs.getString(2));   
                    travels.setArrival(rs.getString(3));
                    travels.setBus_company(rs.getString(4));
                    travels.setPrice(rs.getFloat(6));
                    travels.setTime(rs.getString(7));  
                    travel.add(travels);
                }

            }
        } catch (Exception e) {
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
        return "success";
    }

    public String seatchosen() {
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

    public ArrayList<Travel> getTravel() {
        return travel;
    }

    public void setTravel(ArrayList<Travel> travel) {
        this.travel = travel;
    }

    public Travel getTravelFound() {
        return travelFound;
    }

    public void setTravelFound(Travel travelFound) {
        this.travelFound = travelFound;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}