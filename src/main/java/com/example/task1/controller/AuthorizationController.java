package com.example.task1.controller;

import com.example.task1.exception.InvalidCredentials;
import com.example.task1.exception.UnauthorizedUser;
import com.example.task1.model.Authorities;
import com.example.task1.service.AuthorizationService;
import com.example.task2.annotation.SysUser;
import com.example.task2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) { this.service = service; }

    @GetMapping("/authorize")
    @ResponseBody
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    HashMap<String,String> invalidCredentials(InvalidCredentials e) {
        HashMap hm = new HashMap();
        hm.put("error", "Credentials you are trying to enter are invalid: " + e.getMessage());
        return hm;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    HashMap<String,String> unauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        HashMap hm = new HashMap();
        hm.put("error", "You are not authorized yet: " + e.getMessage());
        return hm;
    }


    // Task2

    @GetMapping("/authorize2")
    public List<Authorities> getAuthorities(@SysUser @Valid User user) {
        return service.getAuthorities(user);
    }
}
