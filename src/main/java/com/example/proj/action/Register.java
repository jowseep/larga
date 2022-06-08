package com.example.proj.action;

import com.opensymphony.xwork2.ActionSupport;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.proj.model.*;;

public class Register extends ActionSupport{
    
    private static final long serialVersionUID = 1L;
    
    private Accounts account;
    private String error = "Random";
    private String firstName, lastName, username, password, birthDate, email; 

    public Register() {
        
    }

    public String execute() throws Exception {
        account = getAccount();
        if(saveToDB()) {
            return "success";
        } else {
            return "fail";
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

    public boolean saveToDB() throws SQLException {
        Connection connection = connectToDB();
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO userinfo(firstname, lastname, birthdate, email, username, password) VALUES('"+account.getFirstName()+"','"+account.getLastName()+"','"+account.getBirthDate()+"','"+account.getEmail()+"','"+account.getUsername()+"','"+account.getPassword()+"')";
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

    public String getError() {
        return error;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}