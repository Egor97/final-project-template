package com.epam.rd.izh.dto;

import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String login;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole() {
        String role;
        if (login.contains("admIn")) {
            role = "Admin";
        } else {
            role = "User";
        }
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
