package com.example.springboot.springbootsolution.controller;

import com.example.springboot.springbootsolution.model.User;
import com.example.springboot.springbootsolution.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    final
    UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String home(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/newget")
    public String newGet(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/newpost")
    public String newPost(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/editget/{id}")
    public String editGet(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/editpatch/{id}")
    public String editPatch(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.editUser(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}

