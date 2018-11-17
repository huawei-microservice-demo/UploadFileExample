package com.service.welcome.controller;

import org.springframework.stereotype.Component;


@Component
public class WelcomeDelegate {

    public String helloworld(String name){

        // Do Some Magic Here!
        return name;
    }
}
