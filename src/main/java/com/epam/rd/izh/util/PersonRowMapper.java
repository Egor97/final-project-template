package com.epam.rd.izh.util;

import com.epam.rd.izh.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonRowMapper implements RowMapper<UserDTO> {

    @Autowired
    UserDTO userDTO;

    @Override
    public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        userDTO.setId(resultSet.getLong("id"));
        userDTO.setLogin(resultSet.getString("login"));
        userDTO.setPassword(resultSet.getString("password"));
        userDTO.setFirstName(resultSet.getString("fname"));
        userDTO.setLastName(resultSet.getString("lname"));
        userDTO.setEmail(resultSet.getString("email"));
        userDTO.setRole(resultSet.getString("role"));

        return userDTO;
    }
}
