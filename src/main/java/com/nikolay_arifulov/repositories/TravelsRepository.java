package com.nikolay_arifulov.repositories;

import com.nikolay_arifulov.models.Travel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelsRepository extends JpaRepository<Travel, Integer> {

    List<Travel> findByTravellerId(Integer travelerId);
}
