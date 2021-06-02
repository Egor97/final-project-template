package com.epam.rd.izh.util;

import com.epam.rd.izh.dto.UserDTO;
import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.entity.UnknownUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingUtilsForUserDTO {

    @Autowired
    UserDTO userDTO;

    public MappingUtilsForUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public UserDTO mapToUserDTO(UnknownUser unknownUser) {
        userDTO.setLogin(unknownUser.getLogin());
        userDTO.setFirstName(unknownUser.getFirstName());
        userDTO.setLastName(unknownUser.getLastName());
        userDTO.setPassword(unknownUser.getPassword());
        userDTO.setEmail(unknownUser.getEmail());
        userDTO.setRole();
        return userDTO;
    }

    public AuthorizedUser mapToAuthorizedUser(UserDTO userDTO) {
        AuthorizedUser user = new AuthorizedUser();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        return user;
    }
}
