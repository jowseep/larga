package com.example.proj.action;

import com.opensymphony.xwork2.ActionSupport;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.proj.model.*;


public class Register extends ActionSupport{
    
    private static final long serialVersionUID = 1L;
    
    private Accounts account;
    private String error = "Random";
    private String encryptedPassword;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            return connection;
        } catch (Exception e) {
            error = e.toString();
        }

        return null;
    }

    public String encrypt(String password) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder s = new StringBuilder();

            for(int i=0;i<hash.length;i++) {
                s.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.toString();
        }
        return encryptedPassword;
    }

    public boolean saveToDB() throws SQLException {
        Connection connection = connectToDB();
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO userinfo(firstname, lastname, email, username, password) VALUES('"+account.getFirstName()+"','"+account.getLastName()+"','"+account.getEmail()+"','"+account.getUsername()+"','"+encrypt(account.getPassword())+"')";
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}