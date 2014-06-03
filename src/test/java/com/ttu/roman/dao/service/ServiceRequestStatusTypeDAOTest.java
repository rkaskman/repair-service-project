package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceRequestStatusTypeDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        ServiceRequestStatusType serviceRequestStatusType = serviceRequestStatusTypeDAO.findAll().get(0);
        assertTrue(serviceRequestStatusType instanceof ServiceRequestStatusType);
    }

}