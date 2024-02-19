package com.universitydemo2.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String login(){
        return "index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }
}
