package com.ttu.roman.service;

import com.ttu.roman.model.Bike;

import java.util.Collection;

public interface BikeService {

    Collection<Bike> getAllBikes();

    Bike getBikeById(int id);

    void saveBike(Bike bike);
}
