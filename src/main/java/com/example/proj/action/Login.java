package com.example.proj.action;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.interceptor.SessionAware;

import java.sql.Timestamp;

import com.example.proj.model.Accounts;
import com.opensymphony.xwork2.ActionSupport;  

public class Login extends ActionSupport implements SessionAware {

    private Accounts account;
    private String error = "Random";
    private String username, password, token;
    String encryptedPassword;
    private Integer user_id;
    private Map<String, Object> userSession;

    public Login() {
    }

    public String execute() throws Exception{
        account = getAccount();
        if(lookToDB()) {
            setUser_id(account.getId());
            userSession.put("token", token);
            userSession.put("user_id", user_id);
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
                token = generateToken();
                String sql = "SELECT * FROM userinfo WHERE username='"+getUsername()+"' AND password='"+encrypt(getPassword())+"'";
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

    public String logout() throws Exception {
        userSession.clear();
        if(token == null){
            return "success";
        } else {
            return "fail";
        }
    }

    public static String generateToken() {
		StringBuilder token = new StringBuilder();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long currentTimeInMilisecond = timestamp.getTime();
		return token.append(currentTimeInMilisecond).append("-")
				.append(UUID.randomUUID().toString()).toString();
	}

    public String updateprofile() {
        return "success";
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, Object> getUserSession() {
        return userSession;
    }

    public void setUserSession(Map<String, Object> userSession) {
        this.userSession = userSession;
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
