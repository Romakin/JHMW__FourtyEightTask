package com.example.task2.model;

import com.example.task1.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository2 {

    List<User> users;

    public UserRepository2() {
        this.users = getRegisteredUsers();
    }

    public List<Authorities> getUserAuthorities(User user) {
        List<Authorities> authorities = new ArrayList<>();
        if (users.contains(user))
            switch (user.getUsername()) {
                case "user":
                    authorities.add(Authorities.READ);
                    break;
                case "manager":
                    authorities.add(Authorities.READ);
                    authorities.add(Authorities.WRITE);
                    break;
                case "admin":
                    authorities.add(Authorities.READ);
                    authorities.add(Authorities.WRITE);
                    authorities.add(Authorities.DELETE);
                    break;
            }
        return authorities;
    }

    private List<User> getRegisteredUsers() {
        return Arrays.asList(new User[]{
                new User("admin", "admin1"),
                new User("manager", "manager1"),
                new User("user", "user1")
        });
    }
}
