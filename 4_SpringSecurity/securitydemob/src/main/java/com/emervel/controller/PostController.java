package com.emervel.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guopm on 03/06/2017.
 */
@RestController
public class PostController {

    @RequestMapping("/posts/")
    public String list(){
        return "list posts...";
    }

    @RequestMapping("/admin/posts/create")
    public String addPost(){
        return "add posts...";
    }

}