package com.nikolay_arifulov.controllers;

import com.nikolay_arifulov.forms.TravelForm;
import com.nikolay_arifulov.models.Travel;
import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.services.TravelsService;
import com.nikolay_arifulov.services.UsersService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final TravelsService travelsService;

    private final UsersService usersService;

    @GetMapping("/")
    public String getUserPage(@AuthenticationPrincipal(expression = "id") Integer userId, Model model) {
        User user = usersService.getUserById(userId);
        List<Travel> travels = travelsService.getTravelsByUserId(userId);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("travels", travels);
        return "user";
    }

    @PostMapping("/")
    public String addTravelToUser(@AuthenticationPrincipal(expression = "id") Integer userId, TravelForm form) {
        travelsService.addTravelToUser(userId, form);
        return "redirect:/";
    }

    @PostMapping("/travel/delete/{travel-id}")
    public String deleteTravel(@PathVariable("travel-id") Integer travelId) {
        travelsService.deleteTravelById(travelId);
        return "redirect:/";
    }
}
