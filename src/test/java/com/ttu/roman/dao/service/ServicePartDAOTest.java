package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServicePart;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServicePartDAOTest extends DAOTest{
    @Test
    public void testRetrieve() throws Exception {
        ServicePart servicePart = servicePartDAO.findAll().get(0);
        assertTrue(servicePart instanceof ServicePart);
        assertTrue(servicePart.getInvoiceRows().size()>0);
        assertNotNull(servicePart.getServiceDevice());
        assertNotNull(servicePart.getServiceOrder());
    }
}