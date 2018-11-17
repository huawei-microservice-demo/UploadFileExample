package com.service.welcome.controller;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestWelcome {

        WelcomeDelegate welcomeDelegate = new WelcomeDelegate();


    @Test
    public void testhelloworld(){

        String expactReturnValue = "hello"; // You should put the expect String type value here.

        String returnValue = welcomeDelegate.helloworld("hello");

        assertEquals(expactReturnValue, returnValue);
    }

}