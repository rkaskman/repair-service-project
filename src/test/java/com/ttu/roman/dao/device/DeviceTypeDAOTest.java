package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.DeviceType;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class DeviceTypeDAOTest extends DAOTest {


    @Test
    public void testRetrieve() throws Exception {
        assertTrue(deviceTypeDAO.count() > 0);
        DeviceType deviceType = deviceTypeDAO.find(5);
        assertNotNull(deviceType);
    }
}