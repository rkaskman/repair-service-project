package com.ttu.roman.controller;

import com.ttu.roman.model.Bike;
import com.ttu.roman.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bikeservice")
public class BikeServiceController {

    @Autowired
    private BikeService bikeService;

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public @ResponseBody Bike getBike(@RequestParam("id") int id) {
        return bikeService.getBikeById(id);
    }
}
