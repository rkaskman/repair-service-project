package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceOrderDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        assertTrue(serviceOrderDAO.findAll().get(0) instanceof ServiceOrder);

    }
}