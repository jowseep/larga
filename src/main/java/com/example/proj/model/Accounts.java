package com.example.proj.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Accounts {
    
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String status;
    private String email;

    public Accounts(int id, String username, String password, String firstName, String lastName, String birthDate, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Accounts() {}

    public Accounts(String username, String password, String firstName, String lastName, String email, String birthDate) {
        // this.id = id;
        this.username = username;
        this.password= password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Accounts rhs = (Accounts) obj;
        return new EqualsBuilder()
                .append(this.username, rhs.username)
                .append(this.password, rhs.password)
                .append(this.firstName, rhs.firstName)
                .append(this.lastName, rhs.lastName)
                .append(this.email, rhs.email)
                .append(this.email, rhs.birthDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder()
            .append(username)
            .append(password)
            .append(firstName)
            .append(lastName)
            .append(email)
            .append(birthDate)
            .toHashCode();
    }

    @Override
    public String toString() {
    return new ToStringBuilder(this)
            .append("username", username)
            .append("password", password)
            .append("firstName", firstName)
            .append("lastName", lastName)
            .append("email", email)
            .append("birthDate", birthDate)
            .toString();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}