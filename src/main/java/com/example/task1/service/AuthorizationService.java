package com.example.task1.service;

import com.example.task1.exception.InvalidCredentials;
import com.example.task1.exception.UnauthorizedUser;
import com.example.task1.model.Authorities;
import com.example.task1.repository.UserRepository;
import com.example.task2.model.User;
import com.example.task2.model.UserRepository2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository, UserRepository2 userRepository2) {
        this.userRepository = userRepository;
        this.userRepository2 = userRepository2;
    }

//    public AuthorizationService(UserRepository2 userRepository2) {
//        this.userRepository2 = userRepository2;
//    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    // Task2
    UserRepository2 userRepository2;

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUsername()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository2.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
