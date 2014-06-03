package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceActionDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceAction serviceAction = serviceActionDAO.findAll().get(0);
        assertTrue(serviceAction instanceof ServiceAction);
        assertNotNull(serviceAction.getServiceActionStatusType());
        assertTrue(serviceAction.getInvoiceRows().size()>0);
    }
}