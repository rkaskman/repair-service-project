package com.ttu.roman.repository;

import com.ttu.roman.model.Bike;

import java.util.List;

public interface BikeRepository {

    List<Bike> getAllBikes();

    Bike getBikeById(int id);

    void saveBike(Bike bike);
}
