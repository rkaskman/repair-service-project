package com.ttu.roman.controller;

import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.model.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @RequestMapping("/update")
    public String add(@RequestParam(value = "serviceRequestId", required = true) Integer serviceRequestId, Model model) {
        model.addAttribute("serviceOrders", serviceOrderDAO.findByServiceRequestId(serviceRequestId));
        return "serviceOrder/update";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost() {
        return "saved";
    }
}
