package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import com.ttu.roman.model.service.ServiceType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceTypeDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        ServiceType serviceType = serviceTypeDAO.find(1);
        assertTrue(serviceType instanceof ServiceType);
        assertTrue(serviceType.getServiceActions().size()>0);
        assertNotNull(serviceType.getServiceUnitType());
    }

}