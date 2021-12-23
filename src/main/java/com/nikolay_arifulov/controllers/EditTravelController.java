package com.nikolay_arifulov.controllers;

import com.nikolay_arifulov.forms.TravelForm;
import com.nikolay_arifulov.models.Travel;
import com.nikolay_arifulov.services.TravelsService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/edit/travel/{travel-id}")
public class EditTravelController {

    private final TravelsService travelsService;

    @GetMapping
    public String getEditTravelPage(@PathVariable("travel-id") Integer travelId, Model model) {
        Travel travel = travelsService.getTravelById(travelId);
        model.addAttribute("travel", travel);
        return "edit_travel";
    }

    @PostMapping
    public String updateTravel(@PathVariable("travel-id") Integer travelId, TravelForm form) {
        travelsService.updateTravel(travelId, form);
        return "redirect:/";
    }
}
