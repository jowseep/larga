package com.example.proj.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.example.proj.model.Accounts;
import com.opensymphony.xwork2.ActionSupport;

public class Index extends ActionSupport implements SessionAware {

    private String token;
    private Map<String, Object> userSession;
    private Accounts account;
    public String error;
    private Integer user_id;

    public String execute() throws SQLException{
        token = (String) userSession.get ("token");
        user_id = (Integer) userSession.get("user_id");
        if(token!=null) {
            if(lookToDB()) {
                return "loggedin";
            } else {
                return "notloggedin";
            }
        } else {
            return "notloggedin";
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
                String sql = "SELECT * FROM userinfo WHERE id='"+user_id+"'";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                if(rs.next()){  
                    Accounts accounts =new Accounts();
                    accounts.setId(rs.getInt(1));
                    accounts.setFirstName(rs.getString(2));   
                    accounts.setLastName(rs.getString(3));
                    accounts.setUsername(rs.getString(6));
                    accounts.setStatus(rs.getString(5));
                    accounts.setEmail(rs.getString(4)); 
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }
}
