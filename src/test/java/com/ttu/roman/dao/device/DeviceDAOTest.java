package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.Device;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import static org.junit.Assert.*;

public class DeviceDAOTest extends DAOTest {


    @Test
    public void testDelete() throws Exception {
        long sumOfDevices = deviceDAO.count();
        deviceDAO.delete(deviceDAO.find(1));
        assertEquals(sumOfDevices - 1, deviceDAO.count());
    }
}