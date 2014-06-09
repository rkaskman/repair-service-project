package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import com.ttu.roman.model.user.EmployeeUserAccount;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.List;

import static com.ttu.roman.service.userlogin.UserAccountUtil.getCurrentUser;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceRequestDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        ServiceRequest serviceRequest = serviceRequestDAO.findAll().get(0);
        assertTrue(serviceRequest instanceof ServiceRequest);
        assertNotNull(serviceRequest.getServiceOrder());
    }

    @Test
    public void testService() throws Exception {
        List<ServiceRequest> serviceRequests = serviceRequestDAO.findAll();
        assertNotNull(serviceRequests);
    }

    @Test
    public void testName() throws Exception {
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setCustomer(customerDAO.find(1));
        serviceRequest.setCreated(new Timestamp(System.currentTimeMillis()));

        ServiceRequestStatusType serviceRequestStatusType = new ServiceRequestStatusType();
        serviceRequestStatusType.setServiceRequestStatusType(1);

        serviceRequest.setServiceRequestStatusType(serviceRequestStatusType);

        serviceRequestDAO.create(serviceRequest);

    }
}