package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.Device;
import org.junit.Test;

import javax.persistence.Persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DeviceDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        Device device = deviceDAO.find(1);
        assertNotNull(device);
        assertNotNull(device.getDeviceType());
        assertTrue(device.getServiceOrders().size()>0);
    }

    @Test
    public void testDelete() throws Exception {
        long sumOfDevices = deviceDAO.count();
        deviceDAO.delete(deviceDAO.find(1));
        assertEquals(sumOfDevices - 1, deviceDAO.count());
    }
}