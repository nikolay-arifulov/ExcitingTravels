package com.nikolay_arifulov.services;

import com.nikolay_arifulov.exceptions.TravelNotFoundException;
import com.nikolay_arifulov.forms.TravelForm;
import com.nikolay_arifulov.models.Travel;
import com.nikolay_arifulov.models.User;
import com.nikolay_arifulov.repositories.TravelsRepository;

import com.nikolay_arifulov.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TravelsServiceImpl implements TravelsService {

    private final TravelsRepository travelsRepository;

    private final UsersRepository usersRepository;

    @Override
    public void addTravelToUser(Integer userId, TravelForm form) {
        User user = usersRepository.getById(userId);

        Travel travel = Travel.builder()
                .header(form.getHeader())
                .description(form.getDescription())
                .country(form.getCountry())
                .location(form.getLocation())
                .startDate(LocalDate.parse(form.getStartDate()))
                .endDate(LocalDate.parse(form.getEndDate()))
                .traveller(user)
                .build();

        travelsRepository.save(travel);
    }

    @Override
    public void deleteTravelById(Integer travelId) {
        travelsRepository.deleteById(travelId);
    }

    @Override
    public Travel getTravelById(Integer travelId) {
        return travelsRepository.findById(travelId).orElseThrow(TravelNotFoundException::new);
    }

    @Override
    public void updateTravel(Integer travelId, TravelForm form) {
        Travel travel = travelsRepository.findById(travelId).orElseThrow(TravelNotFoundException::new);
        travel.setCountry(form.getCountry());
        travel.setLocation(form.getLocation());
        travel.setStartDate(LocalDate.parse(form.getStartDate()));
        travel.setEndDate(LocalDate.parse(form.getEndDate()));
        travel.setHeader(form.getHeader());
        travel.setDescription(form.getDescription());

        travelsRepository.save(travel);
    }

    @Override
    public List<Travel> getTravelsByUserId(Integer userId) {
        return travelsRepository.findByTravellerId(userId);
    }
}
