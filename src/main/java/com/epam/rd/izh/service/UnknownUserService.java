package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.UnknownUser;
import com.epam.rd.izh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UnknownUserService {

    @Autowired
    UserRepository userRepository;

    public UnknownUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addNewRegisteredUser(UnknownUser unknownUser) {
        return userRepository.createNewUser(unknownUser);
    }
}
