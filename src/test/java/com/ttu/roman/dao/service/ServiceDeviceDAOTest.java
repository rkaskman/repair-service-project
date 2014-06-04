package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceDevice;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceDeviceDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceDevice serviceDevice = serviceDeviceDAO.findAll().get(0);
        assertTrue(serviceDevice instanceof ServiceDevice);
        assertNotNull(serviceDevice.getServiceDeviceStatusType());
    }
}