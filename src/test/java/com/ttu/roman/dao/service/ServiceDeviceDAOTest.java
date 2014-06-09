package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.ServiceDevice;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

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
    @Rollback(true)
    public void testBidirectionalManyToMany() throws Exception {
        assertEquals(1, serviceOrderDAO.find(21).getDevices().size());

        long serviceDevicesBefore = serviceDeviceDAO.count();

        long numberBeforeSave = serviceOrderDAO.count();
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrderDAO.create(serviceOrder);
        assertEquals(numberBeforeSave + 1, serviceOrderDAO.count());
        Integer serviceOrderId = serviceOrder.getServiceOrder();
        assertTrue(serviceOrderId>1);

        Device device = deviceDAO.find(3);
        int numberOfDevicesBeforeSave = device.getServiceOrders().size();
        device.getServiceOrders().add(serviceOrder);
        deviceDAO.update(device);
        assertEquals(numberOfDevicesBeforeSave + 1, deviceDAO.find(1).getServiceOrders().size());


        serviceOrderDAO.flushEm(); // delete this  to see the differenece :)

        long serviceDevicesAfter = serviceDeviceDAO.count();

        assertEquals(serviceDevicesBefore+1,serviceDevicesAfter);

        assertEquals(serviceDeviceDAO.findAll().get((int) (serviceDevicesAfter-1)).getDevice(), device);
        assertEquals(serviceDeviceDAO.findAll().get((int) (serviceDevicesAfter-1)).getServiceOrder(), serviceOrder);

        serviceOrderDAO.update(serviceOrder);
        deviceDAO.update(device);
        serviceOrderDAO.flushEm();
        deviceDAO.flushEm();
        serviceDeviceDAO.flushEm();

        assertEquals(1, serviceOrder.getDevices().size());
        assertEquals(1, serviceOrderDAO.find(serviceOrderId).getDevices().size());
    }
}