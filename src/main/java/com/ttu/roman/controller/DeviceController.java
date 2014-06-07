package com.ttu.roman.controller;

import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.form.device.AddDeviceForm;
import com.ttu.roman.form.device.SearchDeviceForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.service.devicetype.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;


@Controller
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private DeviceTypeDAO deviceTypeDAO;

    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("addDeviceForm", new AddDeviceForm());
        addDeviceTypesToModel(model);
        return "device/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(Model model, AddDeviceForm deviceForm) {

        Device device = deviceForm.getDevice();
        Integer deviceTypeId = deviceForm.getDeviceTypeId();

        DeviceType deviceType = deviceTypeDAO.find(deviceTypeId);
        device.setDeviceType(deviceType);

        deviceDAO.create(device);

        model.addAttribute("addDeviceForm", new AddDeviceForm());
        model.addAttribute("successMessage", true);
        addDeviceTypesToModel(model);

        return "device/add";
    }




    @RequestMapping("/search")
    public String search(Model model) {
        addSearchDeviceFormToModel(model);
        return "device/search";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPost(AddDeviceForm deviceForm, Model model) {
        addSearchDeviceFormToModel(model);

        String name = deviceForm.getDevice().getName();
        String deviceModel = deviceForm.getDevice().getModel();
        String regNo = deviceForm.getDevice().getRegNo();
        String clientName = deviceForm.getClientName();

        Set<Device> searchResult = deviceTypeDAO.find(deviceForm.getDeviceTypeId()).getDevices();

        if(!name.isEmpty()){
            searchResult.retainAll(deviceDAO.findDeviceByName(name));
        }

        if(!deviceModel.isEmpty()){
            searchResult.retainAll(deviceDAO.findDeviceByModel(deviceModel));
        }

        if(!regNo.isEmpty()){
            searchResult.retainAll(deviceDAO.findDeviceByRegNo(regNo));
        }

        if(!clientName.isEmpty()){
            searchResult.retainAll(deviceDAO.findDevicesByCustomerName(clientName));
        }

        model.addAttribute("searchResult", searchResult);

        return "device/search";
    }





    private void addSearchDeviceFormToModel(Model model) {
        model.addAttribute("searchDeviceForm", new SearchDeviceForm());
        addDeviceTypesToModel(model);
    }

    private void addDeviceTypesToModel(Model model) {
        Map<Number, String> deviceTypes = new LinkedHashMap();
        for (DeviceType deviceType : deviceTypeService.getOrderedDeviceTypes()) {
            deviceTypes.put(deviceType.getDeviceType(), deviceType.getTypeName());
        }
        model.addAttribute("deviceTypes", deviceTypes);
    }


}