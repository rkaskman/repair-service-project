package com.ttu.roman.controller;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceOrderStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.form.device.AddDeviceForm;
import com.ttu.roman.form.device.SearchDeviceForm;
import com.ttu.roman.form.serviceorder.AddServiceOrderForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
import com.ttu.roman.service.devicetype.DeviceTypeService;
import com.ttu.roman.service.serviceorder.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@RequestMapping("/service-order")
public class ServiceOrderController {

    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceOrderStatusTypeDAO serviceOrderStatusTypeDAO;

    @Autowired
    private DeviceTypeService deviceTypeService;

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @Autowired
    private ServiceOrderService serviceOrderService;

    @RequestMapping("/update")
    public String update(@RequestParam(value = "serviceRequestId", required = true) Integer serviceRequestId, Model model) {
        model.addAttribute("serviceRequest", serviceRequestDAO.find(serviceRequestId));
        model.addAttribute("serviceOrderStatusTypes", serviceOrderStatusTypeDAO.findAll());
        return "serviceOrder/update";
    }

    @RequestMapping(value = "/update/addNewServiceOrder", method = RequestMethod.POST)
    public String updatePost(@RequestParam(value = "serviceRequestId", required = true) Integer serviceRequestId, Model model) {
        return "redirect:/service-order/update?serviceRequestId=" + serviceRequestId;
    }

    @RequestMapping(value = "/addNewServiceOrder")
    public String addNewServiceOrder(@RequestParam(value = "serviceRequestId") Integer serviceRequestId, Model model) {
        model.addAttribute("serviceRequest", serviceRequestDAO.find(serviceRequestId));
        model.addAttribute("deviceTypes", deviceTypeService.getDeviceTypeMap());
        model.addAttribute("searchDeviceForm", new SearchDeviceForm());
        model.addAttribute("addDeviceForm", new AddDeviceForm());
        return "serviceOrder/add";
    }


    @RequestMapping(value = "/saveNewServiceOrder", method = RequestMethod.POST, consumes = "application/json;")
    @ResponseBody
    public Integer saveNewServiceOrder(@RequestBody AddServiceOrderForm addServiceOrderForm) {
        ServiceOrder serviceOrder = serviceOrderService.saveNewServiceOrder(addServiceOrderForm);
        return serviceOrder.getServiceOrder();
    }


    @RequestMapping(value = "/updateServiceOrder")
    public String updateServiceOrder(@RequestParam(value = "serviceOrderId") Integer serviceOrderId, Model model) {
        model.addAttribute("serviceOrder", serviceOrderDAO.find(serviceOrderId));
        model.addAttribute("deviceTypes", deviceTypeService.getDeviceTypeMap());
        model.addAttribute("searchDeviceForm", new SearchDeviceForm());
        model.addAttribute("addDeviceForm", new AddDeviceForm());
        return "serviceOrder/updateServiceOrderRequest";
    }

}
