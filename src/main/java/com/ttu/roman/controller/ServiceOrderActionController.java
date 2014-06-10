package com.ttu.roman.controller;


import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.service.ServiceDeviceDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.ServiceDevice;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.service.serviceorder.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/service-order-device")
public class ServiceOrderActionController {

    @Autowired
    ServiceOrderDAO serviceOrderDAO;

    @Autowired
    ServiceDeviceDAO serviceDeviceDAO;

    @Autowired
    DeviceDAO deviceDAO;

    @RequestMapping(value = "/editServiceDevices")
    public String editServiceDevices(@RequestParam(value = "serviceOrderId") Integer serviceOrderId, Model model) {
        ServiceOrder serviceOrder = serviceOrderDAO.find(serviceOrderId);
        List<Device> deviceList = new ArrayList<>(serviceOrder.getDevices());
        oderDevicesByIdDesc(deviceList);

        return "redirect:/service-order-device/editServiceDevice?serviceOrderId="+serviceOrderId+"&deviceId="+deviceList.get(0).getDevice();
    }

    private void oderDevicesByIdDesc(List<Device> deviceList) {
        Collections.sort(deviceList, new Comparator<Device>() {
            @Override
            public int compare(Device d1, Device d2) {
                return d1.getDevice().compareTo(d2.getDevice());
            }
        });
    }

    @RequestMapping(value = "/editServiceDevice")
    public String editServiceDevice(@RequestParam(value = "serviceOrderId")Integer serviceOrderId, @RequestParam(value = "deviceId")Integer deviceId, Model model) {
        ServiceOrder serviceOrder = serviceOrderDAO.find(serviceOrderId);
        List<Device> deviceList = new ArrayList<>(serviceOrder.getDevices());
        oderDevicesByIdDesc(deviceList);

        ServiceDevice serviceDevice = serviceDeviceDAO.findByServiceOrderAndDevice(serviceOrderId, deviceId);
        model.addAttribute("deviceList", deviceList);
        model.addAttribute("selectedDeviceId", deviceId);
        model.addAttribute("serviceOrderId", serviceOrderId);

        return "serviceDevice/edit";
    }
}
