package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceType;
import com.ttu.roman.model.service.ServiceUnitType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceUnitTypeDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        ServiceUnitType serviceType = serviceUnitTypeDAO.find(1);
        assertTrue(serviceType instanceof ServiceUnitType);
        assertTrue(serviceType.getServiceTypes().size()>0);
    }

}