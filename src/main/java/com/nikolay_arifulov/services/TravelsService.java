package com.nikolay_arifulov.services;

import com.nikolay_arifulov.forms.TravelForm;
import com.nikolay_arifulov.models.Travel;

import java.util.List;

public interface TravelsService {

    void addTravelToUser(Integer userId, TravelForm form);

    void deleteTravelById(Integer travelId);

    Travel getTravelById(Integer travelId);

    void updateTravel(Integer travelId, TravelForm form);

    List<Travel> getTravelsByUserId(Integer userId);
}
