package com.ttu.roman.dao.invoice;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.invoice.InvoiceRow;
import com.ttu.roman.model.invoice.InvoiceStatusType;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceStatusTypeDAOTest extends DAOTest {

    @Test
    public void testRetrieve() throws Exception {
        assertTrue(invoiceStatusTypeDAO.findAll().get(0) instanceof InvoiceStatusType);
    }
}