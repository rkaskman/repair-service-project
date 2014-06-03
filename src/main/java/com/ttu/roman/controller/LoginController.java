package com.ttu.roman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String getBikes(Model model) {
        // model.addAttribute("bicycles", bikeService.getAllBikes());
        return "login";
    }
}
