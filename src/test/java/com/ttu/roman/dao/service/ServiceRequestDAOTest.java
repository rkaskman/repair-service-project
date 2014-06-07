package cTrueom.ttu.roman.dao.service;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.service.ServiceRequest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceRequestDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        ServiceRequest serviceRequest = serviceRequestDAO.findAll().get(0);
        assertTrue(serviceRequest instanceof ServiceRequest);
        assertNotNull(serviceRequest.getServiceOrder());
    }

    @Test
    public void testService() throws Exception {
        List<ServiceRequest> serviceRequests = serviceRequestDAO.findAll();
        assertNotNull(serviceRequests);
    }
}