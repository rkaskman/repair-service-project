package com.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceOrderDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        ServiceOrder serviceOrder = serviceOrderDAO.findAll().get(1);
        assertTrue(serviceOrder instanceof ServiceOrder);
        assertTrue(serviceOrder.getDevices().size()>0);
////        assertNotNull(serviceOrder.getInvoice());
//        assertTrue(serviceOrder.getServiceActions().size()>0);
//        assertTrue(serviceOrder.getServiceParts().size()>0);
//        assertNotNull(serviceOrder.getServiceRequest());

    }

    @Test
    public void testFindByServiceRequestId() throws Exception {
        assertEquals(1, serviceOrderDAO.findByServiceRequestId(1).size());
        ServiceOrder serviceOrder = serviceOrderDAO.findByServiceRequestId(1).get(0);
        assertNotNull(serviceOrder.getDevices());
        assertEquals(2, serviceOrder.getDevices().size());
    }
}