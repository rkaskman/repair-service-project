package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceActionStatusType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ServiceActionStatusTypeDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceActionStatusType serviceActionStatusType = serviceActionStatusTypeDAO.findAll().get(1);
        assertTrue(serviceActionStatusType instanceof ServiceActionStatusType);
        assertTrue(serviceActionStatusType.getServiceActions().size() > 0);
    }
}