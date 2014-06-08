package com.ttu.roman.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
@RequestMapping("/service-order")
public class ServiceOrderController {

    public static final int SO_STATUS_TYPE_SUBMITTED = 1;
    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceOrderStatusTypeDAO serviceOrderStatusTypeDAO;

    @Autowired
    private DeviceTypeService deviceTypeService;

    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @RequestMapping("/update")
    public String update(@RequestParam(value = "serviceRequestId", required = true) Integer serviceRequestId, Model model) {
        model.addAttribute("serviceRequest", serviceRequestDAO.find(serviceRequestId));
        model.addAttribute("serviceOrderStatusTypes", serviceOrderStatusTypeDAO.findAll());
        return "serviceOrder/update";
    }

    @RequestMapping(value = "/update/addNewServiceOrder", method = RequestMethod.POST)
    public String updatePost(@RequestParam(value = "serviceRequestId", required = true) Integer serviceRequestId, Model model) {
        return "redirect:/service-order/update?serviceRequestId="+serviceRequestId;
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
    public String saveNewServiceOrder(@RequestBody AddServiceOrderForm addServiceOrderForm) {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setServiceRequest(serviceRequestDAO.find(addServiceOrderForm.getServiceRequestId()));

        for (Integer deviceId : addServiceOrderForm.getDevices()) {
            Device device = deviceDAO.find(deviceId);
            serviceOrder.getDevices().add(device);
            device.getServiceOrders().add(serviceOrder);
        }

       serviceOrder.setCreated(new Timestamp(System.currentTimeMillis()));
        //todo: uncomment when logged in
//       serviceOrder.setCreatedBy(((EmployeeUserAccount) getCurrentUser()).getEmployee().getEmployee());
        ServiceOrderStatusType serviceOrderStatusType = new ServiceOrderStatusType();
        serviceOrderStatusType.setSoStatusType(SO_STATUS_TYPE_SUBMITTED);
        serviceOrder.setServiceOrderStatusType(serviceOrderStatusType);

        serviceOrderDAO.create(serviceOrder);
        return "ok";
    }
}
