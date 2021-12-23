package com.nikolay_arifulov.controllers;

import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.services.UsersService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/friends")
public class FriendsController {

    private final UsersService usersService;

    @GetMapping
    public String getFriendsPage(@AuthenticationPrincipal(expression = "id") Integer userId, Model model) {
        User user = usersService.getUserById(userId);
        Set<User> friends = user.getFriends();
        model.addAttribute("friends", friends);
        return "friends";
    }

    @PostMapping("/delete/{friend-id}")
    public String deleteFriend(@AuthenticationPrincipal(expression = "id") Integer userId,
                               @PathVariable("friend-id") Integer friendId) {
        usersService.deleteFriendFromUser(userId, friendId);
        return "redirect:/friends";
    }
}
