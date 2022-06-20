package com.example.proj.action;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.proj.model.Accounts;
import com.opensymphony.xwork2.ActionSupport;  

public class Login extends ActionSupport {

    private Accounts account;
    private String error = "Random";
    private String username, password;
    String encryptedPassword;

    public Login() {
    }

    public String execute() throws Exception{

        account = getAccount();
        if(lookToDB()) {
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

    public boolean lookToDB() throws SQLException {
        Connection connection = connectToDB();
        PreparedStatement preparedStatement = null;
        try {
            if (connection != null) {
                String sql = "SELECT * FROM userinfo WHERE username='"+getUsername()+"' AND password='"+encrypt(getPassword())+"'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                if(rs.next()){  
                    Accounts accounts =new Accounts();
                    accounts.setFirstName(rs.getString(2));   
                    accounts.setLastName(rs.getString(3));
                    accounts.setUsername(rs.getString(7));
                    accounts.setBirthDate(rs.getString(4));   
                    accounts.setEmail(rs.getString(5)); 
                    setAccount(accounts);
                    return true;
                } else {
                    return false;
                }
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder s = new StringBuilder();

        for(int i=0;i<hash.length;i++) {
            s.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        return encryptedPassword = s.toString();
    }

    // public String userLogin() throws SQLException {
    //     Connection connection = connectToDB();
    //     PreparedStatement preparedStatement = null;
    //     try {
    //         if (connection != null) {
    //             String sql = "SELECT * FROM userinfo WHERE firstname='"+account.getUsername()+"' AND password='"+account.getPassword()+"'";
    //             preparedStatement = connection.prepareStatement(sql);
    //             ResultSet rs= preparedStatement.executeQuery();

    //             while(rs.next()){ 
    //                 Accounts newaccounts = new Accounts(); 
    //                 newaccounts.setLastName(rs.getString(3));
    //                 newaccounts.setUsername(rs.getString(7));
    //                 newaccounts.setStatus(rs.getString(6));
    //                 newaccounts.setBirthDate(rs.getString(4));   
    //                 newaccounts.setEmail(rs.getString(5)); 
    //                 newaccounts.setFirstName(rs.getString(2));
    //                 setAccountFound(newaccounts);
    //             }
    //             return SUCCESS;
    //         } else {
    //             return "fail";
    //         }
    //     } catch (Exception e) {
    //         error = e.toString();
    //         return "fail";
    //     } finally {
    //         if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
    //         if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    //     }
    // }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

}
