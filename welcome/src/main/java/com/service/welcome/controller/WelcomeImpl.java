package com.service.welcome.controller;


import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.apache.servicecomb.provider.rest.common.RestSchema;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-07-31T15:43:08.536Z")

@RestSchema(schemaId = "welcome")
@RequestMapping(path = "/welcome", produces = MediaType.APPLICATION_JSON)
public class WelcomeImpl {

    @Autowired
    private WelcomeDelegate userWelcomeDelegate;


    @RequestMapping(value = "/helloworld",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public String helloworld( @RequestParam(value = "name", required = true) String name){

        return userWelcomeDelegate.helloworld(name);
    }

}
