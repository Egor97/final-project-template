package com.epam.rd.izh.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class UserDTO {
    @Autowired
    private final PasswordEncoder passwordEncoder;

    private String login;
    private String password;
    private String role;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    public void setRole(String role) {
        if (login.contains("admIn")) {
            role = "Admin";
        } else {
            role = "User";
        }
        this.role = role;
    }
}
