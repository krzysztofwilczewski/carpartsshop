package com.wilczewski.carpartsshop.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/admin")
    public String adminPanel(){
        return "admin";
    }

    @GetMapping("/login")
    public String loginPage(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }

        return "redirect:/";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


}
