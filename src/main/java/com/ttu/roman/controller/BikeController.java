package com.ttu.roman.controller;

import com.ttu.roman.model.Bike;
import com.ttu.roman.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("/s")
public class BikeController {

    @Autowired
    BikeService bikeService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBikes(Model model) {
        model.addAttribute("bicycles", bikeService.getAllBikes());
        return "bikes";
    }

    @RequestMapping(params = "id", method = RequestMethod.GET)
    public String getBikeById(@RequestParam("id") int id, Model model) {
        Bike bike = bikeService.getBikeById(id);
        if (bike != null) {
            model.addAttribute("bike", bikeService.getBikeById(id));
            return "bike";
        }

        model.addAttribute("error", String.format("No bike with id : %d", id));
        return "error";
    }

    @RequestMapping(params = "action", method = RequestMethod.POST)
    public String getBikeById(@RequestParam("action") String action, @Valid Bike bike, final BindingResult result, Model model) {

        if (!"save".equals(action)) {
            model.addAttribute("error", "Wrong action parameter!");
            return "error";
        }
        if (!result.hasErrors()) {
            bikeService.saveBike(bike);
        }
        return "bike";
    }
}