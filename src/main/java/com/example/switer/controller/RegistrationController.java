package com.example.switer.controller;

import com.example.switer.domain.Role;
import com.example.switer.domain.UserLogin;
import com.example.switer.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

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
    public String addUser(UserLogin userLogin, Model model) {
        UserLogin userFromDb = userLoginRepository.findByUserName(userLogin.getUserName());
        if (userFromDb != null) {
            model.addAttribute("message", "User Exists!");
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
