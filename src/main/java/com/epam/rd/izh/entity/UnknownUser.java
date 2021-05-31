package com.epam.rd.izh.entity;

import lombok.Data;

//import java.util.Calendar;

@Data
public class UnknownUser {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
//    private Calendar dob;
    private String email;
    private String role;

    public UnknownUser() {}

//    public UnknownUser(String login, String password, String fName, String lName,
//                       Calendar dob, String email) {
//        this.login = login;
//        this.password = password;
//        this.firstName = fName;
//        this.lastName = lName;
//        this.dob = dob;
//        this.email = email;
//    }
}
