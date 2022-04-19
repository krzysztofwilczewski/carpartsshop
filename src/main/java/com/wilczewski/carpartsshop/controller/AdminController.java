package com.wilczewski.carpartsshop.controller;

import com.wilczewski.carpartsshop.entity.Role;
import com.wilczewski.carpartsshop.entity.User;
import com.wilczewski.carpartsshop.service.RoleService;
import com.wilczewski.carpartsshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public String listAllUsers(Model model){
        List<User> allUsers = userService.listAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model){
        List<Role> roles = roleService.allRoles();
        User user = new User();
        user.setEnabled(true);

        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/user/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes){
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Zapisano nowego użytkownika");
        return "redirect:/admin/users";

    }

}
