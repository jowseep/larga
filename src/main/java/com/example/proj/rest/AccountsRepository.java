package com.example.proj.rest;
import com.example.proj.model.*;
import java.util.*;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountsRepository {
    private static Map<String, Accounts> map = new HashMap<String, Accounts>();
    String error = "random";

    public AccountsRepository() {
    }

    // connection to database
    public Connection connectToDB(){
        Connection connection = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");
    
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return null;
    }
    // GET information
    public Map<String, Accounts> findAllAccounts() {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "SELECT * FROM userinfo";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Accounts accounts=new Accounts();
                    accounts.setId(rs.getInt(1));
                    accounts.setFirstName(rs.getString(2));   
                    accounts.setLastName(rs.getString(3));
                    accounts.setUsername(rs.getString(7)); 
                    accounts.setEmail(rs.getString(5)); 
                    map.put(rs.getString("id"),accounts);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
        return map;
    }

    public Accounts getAccountById(String id) {
        return map.get(id);
    }
    // POST
    public Map<String, Accounts> save(Accounts account) {
        Connection connection = connectToDB();
        Statement statement = null;
        try {
            if (connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO userinfo(username, password, firstName, lastName, email) VALUES('"+account.getUsername()+"','"+account.getPassword()+"','"+account.getFirstName()+"','"+account.getLastName()+"','"+account.getEmail()+"')";
                statement.executeUpdate(sql);
                return map;
            } else {
                error = "DB connection failed";
            }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

        return map;
    }

}