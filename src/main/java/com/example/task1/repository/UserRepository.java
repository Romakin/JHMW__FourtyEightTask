package com.example.task1.repository;

import com.example.task1.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        //ToDo
        if (user.equals("admin") && password.equals("admin1")) {
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
        }
        if (user.equals("manager") && password.equals("manager1")) {
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
        }
        if (user.equals("user") && password.equals("user1")) {
            authorities.add(Authorities.READ);
        }

        return authorities;
    }

}
