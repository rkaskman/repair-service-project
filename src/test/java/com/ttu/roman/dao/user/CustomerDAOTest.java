package com.ttu.roman.dao.user;


import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.user.AbstractCustomer;
import com.ttu.roman.model.user.PersonCustomer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CustomerDAOTest extends DAOTest {

    @Test
    public void testRetrievePersonCustomer() throws Exception {
        AbstractCustomer abstractCustomer = customerDAO.find(1);
        assertNotNull(abstractCustomer);
        assertTrue(abstractCustomer instanceof PersonCustomer);
        assertNotNull(((PersonCustomer)abstractCustomer).getPerson());
    }

    @Test
    public void testFindCustomerByName() throws Exception {
        List<AbstractCustomer> personList = customerDAO.findCustomersByName("Klient");
        assertEquals(1, personList.size());
        AbstractCustomer customer = personList.get(0);
        Assert.assertTrue(customer instanceof PersonCustomer);
        Assert.assertNotNull(((PersonCustomer) customer).getPerson());
        assertEquals("Klient", ((PersonCustomer) customer).getPerson().getLastName());
    }
}
