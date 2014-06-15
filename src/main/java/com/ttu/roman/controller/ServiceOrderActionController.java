package com.ttu.roman.controller;


import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.service.*;
import com.ttu.roman.form.deviceservice.DeviceServiceActionFormEdit;
import com.ttu.roman.form.deviceservice.ServicePartForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.*;
import com.ttu.roman.service.serviceorder.ServiceOrderActionService;
import com.ttu.roman.validator.DeviceServiceActionValidator;
import com.ttu.roman.validator.DeviceServicePartValidator;
import com.ttu.roman.validator.ErrorMapHolder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@SessionAttributes({"deviceList", "selectedDeviceId", "serviceOrderId", "serviceTypeList", "serviceActionStatusTypes",
"serviceParts", "serviceActions","deviceInService"})
@Controller
@RequestMapping("/service-order-device")
public class ServiceOrderActionController {

    @Autowired
    ServiceOrderDAO serviceOrderDAO;

    @Autowired
    ServiceDeviceDAO serviceDeviceDAO;

    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    ServiceTypeDAO serviceTypeDAO;

    @Autowired
    ServiceActionStatusTypeDAO serviceActionStatusTypeDAO;

    @Autowired
    ServiceActionDAO serviceActionDAO;

    @Autowired
    DeviceServiceActionValidator deviceServiceActionValidator;

    @Autowired
    DeviceServicePartValidator deviceServicePartValidator;

    @Autowired
    ServicePartDAO servicePartDAO;

    @Autowired
    ServiceOrderActionService serviceOrderActionService;

    Logger LOG = Logger.getLogger(ServiceOrderActionController.class);

    @RequestMapping(value = "/editServiceDevices")
    public String editServiceDevices(@RequestParam(value = "serviceOrderId") Integer serviceOrderId, Model model) {
        ServiceOrder serviceOrder = serviceOrderDAO.find(serviceOrderId);
        List<Device> deviceList = new ArrayList<>(serviceOrder.getDevices());
        orderDevicesByIdDesc(deviceList);

        return "redirect:/service-order-device/editServiceDevice?serviceOrderId=" + serviceOrderId + "&deviceId=" + deviceList.get(0).getDevice();
    }

    private void orderDevicesByIdDesc(List<Device> deviceList) {
        Collections.sort(deviceList, new Comparator<Device>() {
            @Override
            public int compare(Device d1, Device d2) {
                return d1.getDevice().compareTo(d2.getDevice());
            }
        });
    }

    @RequestMapping(value = "/editServiceDevice")
    public String editServiceDevice(@RequestParam(value = "serviceOrderId") Integer serviceOrderId, @RequestParam(value = "deviceId") Integer deviceId, Model model) {
        ServiceOrder serviceOrder = serviceOrderDAO.find(serviceOrderId);
        List<Device> deviceList = new ArrayList<>(serviceOrder.getDevices());
        orderDevicesByIdDesc(deviceList);

        ServiceDevice serviceDevice = serviceDeviceDAO.findByServiceOrderAndDevice(serviceOrderId, deviceId);
        List<ServiceType> serviceTypeList = serviceTypeDAO.findAll();

        model.addAttribute("deviceList", deviceList);
        model.addAttribute("selectedDeviceId", deviceId);
        model.addAttribute("serviceOrderId", serviceOrderId);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("serviceActions", serviceDevice.getServiceActions());
        model.addAttribute("serviceParts", serviceDevice.getServiceParts());
        model.addAttribute("serviceActionStatusTypes", serviceActionStatusTypeDAO.findAll());
        model.addAttribute("deviceInService", serviceDevice.getServiceDevice());

        return "serviceDevice/edit";
    }

    @RequestMapping(value = "saveEditedServiceAction", method = RequestMethod.POST)
    public String saveEditedServiceAction(@ModelAttribute("deviceServiceActionFormEdit") DeviceServiceActionFormEdit deviceServiceActionFormEdit, Model model) {

        ServiceAction serviceAction = serviceActionDAO.find(deviceServiceActionFormEdit.getServiceActionId());
        Map<String, String> errors = deviceServiceActionValidator.validate(deviceServiceActionFormEdit);

        if(!errors.isEmpty()) {
            model.addAttribute("actionErrorMapHolder", new ErrorMapHolder(errors, deviceServiceActionFormEdit.getServiceActionId()));
            model.addAttribute("invalidAction", deviceServiceActionFormEdit);
            model.addAttribute("fail", true);
        } else {
            serviceOrderActionService.updateServiceAction(deviceServiceActionFormEdit, serviceAction);
            model.addAttribute("success", true);
        }

        model.addAttribute("serviceActions", serviceAction.getServiceDevice().getServiceActions());

        return "serviceDevice/edit";
    }

    @RequestMapping(value = "saveNewServiceAction", method = RequestMethod.POST)
    public String saveNewServiceAction(@ModelAttribute("deviceServiceActionFormEdit") DeviceServiceActionFormEdit newFormServiceAction, Model model) {

        Map<String, String> errors = deviceServiceActionValidator.validate(newFormServiceAction);

        if(!errors.isEmpty()) {
            model.addAttribute("newActionErrors", errors);
            model.addAttribute("invalidNewAction", newFormServiceAction);
            model.addAttribute("fail", true);
        }
        else {
            ServiceDevice serviceDevice = serviceOrderActionService.saveNewServiceAction(newFormServiceAction);
            model.addAttribute("success", true);
            model.addAttribute("serviceActions", serviceDevice.getServiceActions());
            model.addAttribute("deviceInService", serviceDevice.getServiceDevice());
        }

        return "serviceDevice/edit";
    }


    @RequestMapping(value = "saveEditedServicePart", method = RequestMethod.POST)
    public String saveEditedPart(@ModelAttribute(value = "servicePartForm")ServicePartForm servicePartForm, Model model) {

        ServicePart servicePart = servicePartDAO.find(servicePartForm.getServicePartId());
        ServiceDevice serviceDevice = servicePart.getServiceDevice();

        Map<String, String> errors = deviceServicePartValidator.validate(servicePartForm);

        if(!errors.isEmpty()) {
            model.addAttribute("partErrorMapHolder", new ErrorMapHolder(errors, servicePart.getServicePart()));
            model.addAttribute("invalidPart", servicePartForm);
            model.addAttribute("fail", true);
        }
        else {
            serviceOrderActionService.updateServicePart(servicePartForm, servicePart);
            model.addAttribute("success", true);
        }

        model.addAttribute("serviceParts", serviceDevice.getServiceParts());

        return "serviceDevice/edit";
    }


    @RequestMapping(value = "saveNewServicePart", method = RequestMethod.POST)
    public String saveNewPart(@ModelAttribute(value = "servicePartForm")ServicePartForm servicePartForm, Model model) {
        Map<String, String> errors = deviceServicePartValidator.validate(servicePartForm);
        ServiceDevice serviceDevice = serviceDeviceDAO.find(servicePartForm.getDeviceInService());

        if(!errors.isEmpty()) {
            model.addAttribute("partErrors", errors);
            model.addAttribute("newInvalidPart", servicePartForm);
            model.addAttribute("fail", true);
        } else {
            serviceOrderActionService.saveServicePart(servicePartForm, serviceDevice);

            serviceDevice = serviceDeviceDAO.find(servicePartForm.getDeviceInService());
            model.addAttribute("success", true);
        }

        model.addAttribute("serviceParts", serviceDevice.getServiceParts());

        return "serviceDevice/edit";
    }
}