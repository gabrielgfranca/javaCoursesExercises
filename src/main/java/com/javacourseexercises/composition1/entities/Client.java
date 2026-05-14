package com.javacourseexercises.composition1.entities;

import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date dateOfBirth;

    public Client() {}

    public Client(String name, String email, Date dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
