package com.ttu.roman.dao.invoice;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.invoice.InvoiceRow;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceRowDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        InvoiceRow invoiceRow = invoiceRowDAO.findAll().get(6);
        assertTrue(invoiceRow instanceof InvoiceRow);
        assertNotNull(invoiceRow.getServiceAction());
    }
}