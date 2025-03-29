package com.example.aulaSeteSpring.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class Welcome {
    public String welcome(){
        return "Bem vindo ao teste, teste (❁´◡`❁)";
    }
}
