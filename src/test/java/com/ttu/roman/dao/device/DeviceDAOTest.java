package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeviceDAOTest extends DAOTest {


    @Test
    public void testDelete() throws Exception {
        long sumOfDevices = deviceDAO.count();
        deviceDAO.delete(deviceDAO.find(1));
        assertEquals(sumOfDevices - 1, deviceDAO.count());
    }
}