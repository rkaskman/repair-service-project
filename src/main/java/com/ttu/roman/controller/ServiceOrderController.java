package com.ttu.roman.controller;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.service.ServiceNoteDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceOrderStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.form.device.AddDeviceForm;
import com.ttu.roman.form.device.SearchDeviceForm;
import com.ttu.roman.form.serviceorder.AddServiceOrderForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
import com.ttu.roman.model.service.ServicePart;
import com.ttu.roman.model.user.AbstractCustomer;
import com.ttu.roman.model.user.CustomerUserAccount;
import com.ttu.roman.note.ServiceOrderNoteForm;
import com.ttu.roman.service.ServiceNoteService;
import com.ttu.roman.service.devicetype.DeviceTypeService;
import com.ttu.roman.service.serviceorder.ServiceOrderService;
import com.ttu.roman.service.userlogin.UserAccountUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

import static java.math.BigInteger.valueOf;


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

    @Autowired
    private ServiceNoteService serviceNoteService;

    Logger LOG = Logger.getLogger(ServiceOrderController.class);


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

    @RequestMapping(value = "/saveUpdatedServiceOrder", method = RequestMethod.POST, consumes = "application/json;")
    @ResponseBody
    public Integer saveUpdatedServiceOrder(@RequestBody AddServiceOrderForm updatedServiceOrderData) {
        ServiceOrder serviceOrder = serviceOrderService.saveUpdatedServiceOrder(updatedServiceOrderData);
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

    @RequestMapping(value = "/listAll")
    public String listServiceOrders(Model model) {
        model.addAttribute("serviceOrders", serviceOrderDAO.findAll());
        return "serviceOrder/all";
    }

    @RequestMapping(value = "/customerOrders")
    public String getCustomerOrders(Model model) {
        AbstractCustomer abstractCustomer = ((CustomerUserAccount) UserAccountUtil.getCurrentUser()).getAbstractCustomer();
        Integer customerId = abstractCustomer.getCustomer();
        List<ServiceOrder> serviceOrderList = serviceOrderDAO.findCustomerOrdersByCustomerId(customerId);

        model.addAttribute("customerServiceOrders", serviceOrderList);
        model.addAttribute("customerName", abstractCustomer.retrieveCustomerName());
        return "serviceOrder/customerOrders";
    }

    @RequestMapping(value = "/showUserServiceOrder")
    public String getUserServiceOrder(@RequestParam(value = "serviceOrderId") Integer serviceOrderId, Model model) {

        ServiceOrder serviceOrder = serviceOrderDAO.find(serviceOrderId);

        model.addAttribute("serviceOrder", serviceOrder);
        model.addAttribute("currentCost", getServiceOrderCurrentCost(serviceOrder));

        System.out.println("yolo");
        return "serviceOrder/userServiceOrder";
    }

    private BigInteger getServiceOrderCurrentCost(ServiceOrder serviceOrder) {
        BigInteger currentCost = valueOf(0);

        for (ServiceAction serviceAction : serviceOrder.getServiceActions()) {
            currentCost = currentCost.add(serviceAction.getPrice().multiply(serviceAction.getServiceAmount()));
        }

        for (ServicePart servicePart : serviceOrder.getServiceParts()) {
            currentCost = currentCost.add(servicePart.getPartPrice().multiply(valueOf(servicePart.getPartCount())));
        }

        return currentCost;
    }

    @RequestMapping(value = "/addCustomerNote", method = RequestMethod.POST)
    public String addCustomerNote(@ModelAttribute(value = "serviceOrderNoteForm") ServiceOrderNoteForm serviceOrderNoteForm, Model model) {

        serviceNoteService.insertNote(serviceOrderNoteForm, new Integer(1));
        ServiceOrder serviceOrder = serviceOrderDAO.find(serviceOrderNoteForm.getServiceOrderId());
        model.addAttribute("serviceOrder", serviceOrder);
        model.addAttribute("currentCost", getServiceOrderCurrentCost(serviceOrder));

        return "serviceOrder/userServiceOrder";
    }


}
