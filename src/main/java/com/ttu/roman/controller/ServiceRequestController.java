package com.ttu.roman.controller;

import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.dao.service.ServiceRequestStatusTypeDAO;
import com.ttu.roman.dao.user.CustomerDAO;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import com.ttu.roman.model.user.AbstractCustomer;
import com.ttu.roman.model.user.EmployeeUserAccount;
import com.ttu.roman.response.CustomerResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.ttu.roman.service.userlogin.UserAccountUtil.getCurrentUser;
import static java.util.Collections.emptyList;


@Controller
@RequestMapping("/service-request")
@SessionAttributes("serviceRequest")
public class ServiceRequestController {
    public static final int SERVICE_REQUEST_STATUS_REGISTERED = 1;

    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceRequestStatusTypeDAO serviceRequestStatusTypeDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        return "serviceRequest/add";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<ServiceRequest> serviceRequests = serviceRequestDAO.findAll();
        Collections.reverse(serviceRequests);
        model.addAttribute("serviceRequests", serviceRequests);
        return "serviceRequest/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(Model model, ServiceRequest serviceRequest) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        model.addAttribute("successMessage", true);

        ServiceRequestStatusType serviceRequestStatusType = serviceRequestStatusTypeDAO.find(SERVICE_REQUEST_STATUS_REGISTERED);
        serviceRequest.setServiceRequestStatusType(serviceRequestStatusType);

        serviceRequestDAO.create(serviceRequest);

        return "serviceRequest/add";
    }

    @RequestMapping(value = "/getCustomerDataByName", method = RequestMethod.GET)
    @ResponseBody
    public List<CustomerResponseData> getCustomerDataByName(@RequestParam("name") String name) {
        List<AbstractCustomer> customers = customerDAO.findCustomersByName(name);
        if (!customers.isEmpty()) {
            AbstractCustomer customer = customers.get(0);
            CustomerResponseData customerResponseData = new CustomerResponseData(customer.getCustomer(), customer.retrieveCustomerName());
            return Arrays.asList(customerResponseData);
        }
        return emptyList();
    }

    @RequestMapping(value = "/saveServiceRequest", method = RequestMethod.POST)
    public String saveServiceRequest(@RequestParam("customerId") Integer customerId, @ModelAttribute("serviceRequest") ServiceRequest serviceRequest, BindingResult result, Model model) {

        if (serviceRequest.getServiceRequest() == null) {
            createServiceRequest(customerId, serviceRequest);
        } else {
            updateServiceRequest(customerId, serviceRequest);
        }

        model.addAttribute("customer", serviceRequest.getCustomer());
        model.addAttribute("successMessage", true);
        model.addAttribute("statusTypes", getServiceRequestStatusTypes());


        //todo: service order redirect button
        return "serviceRequest/update";
    }

    private void updateServiceRequest(Integer customerId, ServiceRequest serviceRequest) {
        if (!customerId.equals(serviceRequest.getCustomer().getCustomer())) {
            serviceRequest.setCustomer(customerDAO.find(customerId));
        }
        serviceRequestDAO.update(serviceRequest);
    }

    private void createServiceRequest(Integer customerId, ServiceRequest serviceRequest) {
        serviceRequest.setCustomer(customerDAO.find(customerId));
        serviceRequest.setCreated(new Timestamp(System.currentTimeMillis()));

        ServiceRequestStatusType serviceRequestStatusType = new ServiceRequestStatusType();
        serviceRequestStatusType.setServiceRequestStatusType(SERVICE_REQUEST_STATUS_REGISTERED);

        serviceRequest.setServiceRequestStatusType(serviceRequestStatusType);

        serviceRequest.setCreatedBy(((EmployeeUserAccount) getCurrentUser()).getEmployee());
        serviceRequestDAO.create(serviceRequest);
    }

    private Map<Number, String> getServiceRequestStatusTypes() {
        Map<Number, String> serviceRequestStatusTypeMap = new LinkedHashMap<>();
        List<ServiceRequestStatusType> serviceRequestStatusTypes = serviceRequestStatusTypeDAO.findAll();
        for (ServiceRequestStatusType serviceRequestStatusType : serviceRequestStatusTypes) {
            serviceRequestStatusTypeMap.put(serviceRequestStatusType.getServiceRequestStatusType(), serviceRequestStatusType.getTypeName());
        }
        return serviceRequestStatusTypeMap;
    }
}