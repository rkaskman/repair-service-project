package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ServiceOrderStatusTypeDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        assertTrue(serviceOrderStatusTypeDAO.findAll().get(0) instanceof ServiceOrderStatusType);
    }
}