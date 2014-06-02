package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceRequestDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        ServiceRequest serviceRequest = serviceRequestDAO.findAll().get(0);
        assertTrue(serviceRequest instanceof ServiceRequest);
        assertNotNull(serviceRequest.getServiceRequestStatusTypeFk());
    }

}