package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.Device;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void testGetCustomerDevices() throws Exception {
        List<Device> devices = deviceDAO.findDevicesByCustomerName("Klient");
        assertEquals(2, devices.size());
        assertEquals("Insener Garini hyperboloid", devices.get(0).getName());
        assertEquals("Laserkahur", devices.get(1).getName());
    }
}