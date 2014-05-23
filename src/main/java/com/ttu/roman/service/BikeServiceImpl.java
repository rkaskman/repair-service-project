package com.ttu.roman.service;

import com.ttu.roman.model.Bike;
import com.ttu.roman.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class BikeServiceImpl implements BikeService{

    @Autowired
    private BikeRepository bikeRepository;

    @Transactional(readOnly = true)
    @Override
    public Collection<Bike> getAllBikes() {
        return bikeRepository.getAllBikes();
    }

    @Transactional
    @Override
    public Bike getBikeById(int id) {
        return bikeRepository.getBikeById(id);
    }

    @Transactional
    @Override
    public void saveBike(Bike bike) {
       bikeRepository.saveBike(bike);
    }
}