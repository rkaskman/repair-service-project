package com.ttu.roman.dao.device;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.device.DeviceType;
import org.junit.Test;

public class DeviceTypeDAOTest extends DAOTest {


    @Test
    public void testRetrieve() throws Exception {
        DeviceType deviceType = deviceTypeDAO.find(1);

    }
}