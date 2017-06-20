package com.example.abc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by guopm on 13/05/2017.
 */
@Component
@ConfigurationProperties(prefix = "persona")
public class Persona {
    private String name;
    private String lastName;
    private String emailAddress;


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString(){
        return "name="+name+", last name="+lastName;
    }
}
