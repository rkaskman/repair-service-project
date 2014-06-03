package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.DeviceType;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class DeviceTypeDAOTest extends DAOTest {


    @Test
    public void testRetrieve() throws Exception {
        DeviceType deviceType = deviceTypeDAO.find(1);
        assertNotNull(deviceType);
    }
}