package com.nikolay_arifulov.controllers;

import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.services.UsersService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/{username}")
public class FriendController {

    private final UsersService usersService;

    @GetMapping
    public String getFriendPage(@PathVariable("username") String username, Model model) {
        User user = usersService.getUserByUsername(username);
        Integer age = usersService.getAge(user);
        model.addAttribute("user", user);
        model.addAttribute("userAge", age);
        return "friend";
    }
}