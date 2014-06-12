package com.ttu.roman.controller;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.form.device.AddDeviceForm;
import com.ttu.roman.form.device.SearchDeviceForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.service.device.DeviceSearchService;
import com.ttu.roman.service.devicetype.DeviceTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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

    @Autowired
    private DeviceSearchService deviceSearchService;

    Logger LOG = Logger.getLogger(DeviceController.class);

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("addDeviceForm", new AddDeviceForm());
        addDeviceTypesToModel(model);
        return "device/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(Model model, @Valid AddDeviceForm deviceForm, BindingResult result) {
        addDeviceTypesToModel(model);

        if (!result.hasErrors()) {
            model.addAttribute("addDeviceForm", new AddDeviceForm());
            Device device = deviceForm.getDevice();
            Integer deviceTypeId = deviceForm.getDeviceTypeId();
            DeviceType deviceType = deviceTypeDAO.find(deviceTypeId);
            device.setDeviceType(deviceType);
            deviceDAO.create(device);
            model.addAttribute("successMessage", true);
        }

        return "device/add";
    }

    @RequestMapping("/search")
    public String search(Model model) {
        addSearchDeviceFormToModel(model);
        return "device/search";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPost(SearchDeviceForm deviceForm, Model model) {
        addSearchDeviceFormToModel(model);

        model.addAttribute("searchResult", getDeviceSearchResult(deviceForm));

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

    @RequestMapping(value = "/searchForDevices", method = RequestMethod.POST, consumes = "application/json;")
    @ResponseBody
    public Collection<SearchDeviceForm> searchForDevices(@RequestBody SearchDeviceForm searchDeviceForm) {
        return getDeviceSearchResult(searchDeviceForm);
    }

    private Collection<SearchDeviceForm> getDeviceSearchResult(SearchDeviceForm searchDeviceForm) {
        return deviceSearchService.getOrderedDeviceTypes(searchDeviceForm);
    }


    @RequestMapping(value = "addNewDevice", method = RequestMethod.POST, consumes = "application/json;")
    @ResponseBody
    public Device addNewDeviceService(@RequestBody AddDeviceForm addDeviceForm) {
        Device device = addDeviceForm.getDevice();
        DeviceType deviceType = deviceTypeDAO.find(addDeviceForm.getDeviceTypeId());
        device.setDeviceType(deviceType);
        deviceDAO.create(device);

        Device responseDevice = new Device();
        responseDevice.setName(device.getName());
        responseDevice.setDevice(device.getDevice());

        return responseDevice;
    }
}