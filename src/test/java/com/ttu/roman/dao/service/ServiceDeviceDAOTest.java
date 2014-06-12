package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.ServiceDevice;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceDeviceDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceDevice serviceDevice = serviceDeviceDAO.findAll().get(0);
        assertTrue(serviceDevice instanceof ServiceDevice);
        assertNotNull(serviceDevice.getServiceDeviceStatusType());
        assertTrue(serviceDevice.getServiceParts().size()>0);
        assertNotNull(serviceDevice.getDevice());
        assertNotNull(serviceDevice.getServiceOrder());
    }

    @Test
    public void testFindServiceDeviceByServiceOrderAndDevice() throws Exception {
        ServiceDevice serviceDevices = serviceDeviceDAO.findByServiceOrderAndDevice(1, 1);
        assertNotNull(serviceDevices);
    }
}