package com.ttu.roman.controller;


import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.service.*;
import com.ttu.roman.form.deviceservice.DeviceServiceActionFormEdit;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.*;
import com.ttu.roman.model.user.EmployeeUserAccount;
import com.ttu.roman.service.userlogin.UserAccountUtil;
import com.ttu.roman.validator.DeviceServiceActionValidator;
import com.ttu.roman.validator.ErrorMapHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

import static com.ttu.roman.service.userlogin.UserAccountUtil.*;

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
        } else {
            updateServiceAction(deviceServiceActionFormEdit, serviceAction);
        }

        List<Device> deviceList = new ArrayList<>(serviceAction.getServiceOrder().getDevices());
        orderDevicesByIdDesc(deviceList);

        model.addAttribute("deviceList", deviceList);
        model.addAttribute("selectedDeviceId", serviceAction.getServiceDevice().getDevice().getDevice());
        model.addAttribute("serviceOrderId", serviceAction.getServiceOrder().getServiceOrder());
        model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
        model.addAttribute("serviceActions", serviceAction.getServiceDevice().getServiceActions());
        model.addAttribute("serviceActionStatusTypes", serviceActionStatusTypeDAO.findAll());
        model.addAttribute("deviceInService", serviceAction.getServiceDevice().getServiceDevice());

        return "serviceDevice/edit";
    }

    private void updateServiceAction(DeviceServiceActionFormEdit deviceServiceActionFormEdit, ServiceAction serviceAction) {
        serviceAction.setPrice(new BigInteger(deviceServiceActionFormEdit.getPrice()));
        serviceAction.setServiceAmount(new BigInteger(deviceServiceActionFormEdit.getServiceAmount()));
        serviceAction.setActionDescription(deviceServiceActionFormEdit.getActionDescription());
        serviceAction.setServiceActionStatusType(serviceActionStatusTypeDAO.find(deviceServiceActionFormEdit.getServiceActionStatusType()));
        serviceAction.setServiceType(serviceTypeDAO.find(deviceServiceActionFormEdit.getServiceType()));

        serviceActionDAO.update(serviceAction);
    }

    @RequestMapping(value = "saveNewServiceAction", method = RequestMethod.POST)
    public String saveNewServiceAction(@ModelAttribute("deviceServiceActionFormEdit") DeviceServiceActionFormEdit newFormServiceAction, Model model) {

        Map<String, String> errors = deviceServiceActionValidator.validate(newFormServiceAction);
        ServiceDevice serviceDevice = serviceDeviceDAO.find(newFormServiceAction.getDeviceInService());

        if(!errors.isEmpty()) {
            model.addAttribute("newActionErrors", errors);
            model.addAttribute("invalidNewAction", newFormServiceAction);
        }
        else {
            ServiceAction serviceAction = new ServiceAction();
            serviceAction.setActionDescription(newFormServiceAction.getActionDescription());
            serviceAction.setServiceType(serviceTypeDAO.find(newFormServiceAction.getServiceType()));
            serviceAction.setServiceActionStatusType(serviceActionStatusTypeDAO.find(newFormServiceAction.getServiceActionStatusType()));
            serviceAction.setServiceAmount(new BigInteger(newFormServiceAction.getServiceAmount()));
            serviceAction.setPrice(new BigInteger(newFormServiceAction.getPrice()));
            serviceAction.setPrice(new BigInteger(newFormServiceAction.getPrice()));
            serviceAction.setServiceDevice(serviceDevice);
            serviceAction.setServiceOrder(serviceDevice.getServiceOrder());
            serviceAction.setCreated(new Timestamp(System.currentTimeMillis()));

            //todo: uncomment when logged in
//            serviceAction.setCreatedBy(((EmployeeUserAccount) getCurrentUser()).getEmployee().getEmployee());

            serviceActionDAO.create(serviceAction);
            serviceDevice = serviceDeviceDAO.find(newFormServiceAction.getDeviceInService());
        }

        ArrayList<Device> deviceList = new ArrayList<>(serviceDevice.getServiceOrder().getDevices());
        orderDevicesByIdDesc(deviceList);

        model.addAttribute("deviceList", deviceList);
        model.addAttribute("selectedDeviceId", newFormServiceAction.getServiceDeviceId());
        model.addAttribute("serviceOrderId", serviceDevice.getServiceOrder().getServiceOrder());
        model.addAttribute("serviceTypeList", serviceTypeDAO.findAll());
        model.addAttribute("serviceActions", serviceDevice.getServiceActions());
        model.addAttribute("serviceActionStatusTypes", serviceActionStatusTypeDAO.findAll());
        model.addAttribute("deviceInService", serviceDevice.getServiceDevice());

        return "serviceDevice/edit";
    }

    @RequestMapping(value = "saveEditedServicePart", method = RequestMethod.POST)
    public String saveEditedPart() {
        return "";
    }
}
