package com.ttu.roman.dao.invoice;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.invoice.InvoiceRow;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceRowDAOTest extends DAOTest{

    @Test
    public void testRetrieve() throws Exception {
        assertTrue(invoiceRowDAO.findAll().get(0) instanceof InvoiceRow);
    }
}