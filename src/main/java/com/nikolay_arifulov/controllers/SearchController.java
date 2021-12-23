package com.nikolay_arifulov.controllers;

import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.services.UsersService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@Controller
@RequestMapping("/search")
public class SearchController {

    private final UsersService usersService;

    @GetMapping
    public String getSearchPage() {
        return "search";
    }

    @PostMapping
    public String searchUsers(@AuthenticationPrincipal(expression = "id") Integer userId,
                              @RequestParam("name") String name, Model model) {

        User user = usersService.getUserById(userId);
        Set<User> users = usersService.getUsersByNameWithoutUserById(name, userId);
        model.addAttribute("currentUser", user);
        model.addAttribute("users", users);
        return "search";
    }

    @PostMapping(value = "/add/{friend-id}")
    public String addFriendToUser(@AuthenticationPrincipal(expression = "id") Integer userId,
                                  @PathVariable("friend-id") Integer friendId) {

        usersService.addFriendToUser(userId, friendId);
        return "redirect:/";
    }
}