package com.ttu.roman.controller;

import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.dao.user.CustomerDAO;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import com.ttu.roman.model.user.AbstractCustomer;
import com.ttu.roman.model.user.EmployeeUserAccount;
import com.ttu.roman.response.CustomerResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static com.ttu.roman.service.userlogin.UserAccountUtil.getCurrentUser;
import static java.util.Collections.emptyList;


@Controller
@RequestMapping("/service-request")
public class ServiceRequestController {
    public static final int SERVICE_REQUEST_STATUS_REGISTERED = 1;
    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        return "serviceRequest/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost() {
        return "saved";
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
    public String saveServiceRequest(@RequestParam("customerId") int customerId, ServiceRequest serviceRequest, BindingResult result, Model model) {

        serviceRequest.setCustomer(customerDAO.find(customerId));
        serviceRequest.setCreated(new Timestamp(System.currentTimeMillis()));

        ServiceRequestStatusType serviceRequestStatusType = new ServiceRequestStatusType();
        serviceRequestStatusType.setServiceRequestStatusType(SERVICE_REQUEST_STATUS_REGISTERED);

        serviceRequest.setServiceRequestStatusType(serviceRequestStatusType);

        serviceRequest.setCreatedBy(((EmployeeUserAccount) getCurrentUser()).getEmployee());
        serviceRequestDAO.create(serviceRequest);
        return "serviceRequest/add";
    }
}