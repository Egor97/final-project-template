package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizedUserService {

    @Autowired
    UserRepository userRepository;

    public AuthorizedUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthorizedUser getAuthorizedUser(String login) {
        return userRepository.getAuthorizedUserByLogin(login);
    }
}
