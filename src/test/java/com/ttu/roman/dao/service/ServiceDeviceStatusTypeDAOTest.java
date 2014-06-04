package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceDeviceStatusType;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceDeviceStatusTypeDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceDeviceStatusType serviceDeviceStatusType = serviceDeviceStatusTypeDAO.findAll().get(2);
        assertTrue(serviceDeviceStatusType instanceof ServiceDeviceStatusType);
        assertNotNull(serviceDeviceStatusType.getTypeName());
        assertTrue(serviceDeviceStatusType.getServiceDevices().size()>0);
    }
}