package com.ttu.roman.controller;

import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.form.device.AddDeviceForm;
import com.ttu.roman.form.device.SearchDeviceForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.model.service.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
@RequestMapping("/service-request")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        return "serviceRequest/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost() {
        return "saved";
    }




}