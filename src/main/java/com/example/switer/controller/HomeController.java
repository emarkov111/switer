package com.example.switer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping(path = "/homeIndex")
    public String getHomeForm(Model model){
        return "home";
    }
}
