package com.wilczewski.carpartsshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/admin")
    public String adminPanel(){
        return "admin";
    }
}
