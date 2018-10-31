package com.example.switer.controller;

import com.example.switer.domain.Role;
import com.example.switer.domain.UserLogin;
import com.example.switer.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @GetMapping("/registration")
    public String registration() {
        return "/registration";
    }

    @PostMapping("/registration")
    public String addUser(UserLogin userLogin, Map<String, Object> model) {
        UserLogin userFromDb = userLoginRepository.findByUserName(userLogin.getUserName());
        if (userFromDb != null) {
            model.put("message", "User Exists!");
            return "/registration";
        }
        userLogin.setActivity(true);
        userLogin.setRoles(Collections.singleton(Role.USER));
        userLogin.setUserName(userLogin.getUserName());
        userLogin.setPassword(userLogin.getPassword());
        userLoginRepository.save(userLogin);
        return "redirect:/login";
    }

}
