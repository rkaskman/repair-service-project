package com.ttu.roman.controller;

import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceOrderStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
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
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceOrderStatusTypeDAO serviceOrderStatusTypeDAO;

    @RequestMapping("/update")
    public String update(@RequestParam(value = "serviceRequestId", required = true) Integer serviceRequestId, Model model) {
        model.addAttribute("serviceRequest", serviceRequestDAO.find(serviceRequestId));
        model.addAttribute("serviceOrderStatusTypes", serviceOrderStatusTypeDAO.findAll());
        return "serviceOrder/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePost() {
        return "saved";
    }
}
