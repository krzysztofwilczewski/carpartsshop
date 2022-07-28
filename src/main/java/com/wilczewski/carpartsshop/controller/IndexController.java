package com.wilczewski.carpartsshop.controller;

import com.wilczewski.carpartsshop.entity.Category;
import com.wilczewski.carpartsshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    private CategoryService categoryService;

    @Autowired
    public IndexController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

    @GetMapping("/login")
    public String loginPage() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        return "redirect:/";
    }

    @GetMapping("")
    public String index(Model model) {
        List<Category> listCategories = categoryService.listNoChildrenCategories();
        model.addAttribute("listCategories", listCategories);

        return "index";
    }


}
