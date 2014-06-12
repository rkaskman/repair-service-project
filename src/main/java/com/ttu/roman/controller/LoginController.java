package com.ttu.roman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value = "error", required = false) boolean error,
                               ModelMap model) {

        model.put("error", error ? "You have entered an invalid username or password!" : "" );
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String redirectToWelcome() {
        return "redirect:welcome";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String getDeniedPage() {
        return "denied";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "redirect:/service-request/add   ";
    }

    @RequestMapping(value = "/welcomeUser", method = RequestMethod.GET)
    public String welcomeUser() {
        return "welcomeUser";
    }
}
