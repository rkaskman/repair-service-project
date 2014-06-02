package com.ttu.roman.dao.invoice;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.service.ServiceOrder;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        assertTrue(invoiceDAO.findAll().get(0) instanceof Invoice);
    }
}