package com.emervel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guopm on 20/06/2017.
 */
@RestController
public class RegistrationController {

    @RequestMapping("/signup")
    public String signup(){
        return "Please Sing up for ";
    }

    @RequestMapping("/signup-success")
    public String signupSuccess(){
        return "Thank you for registering";
    }
}
