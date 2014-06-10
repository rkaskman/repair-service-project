package com.ttu.roman.service.invoice;

import com.ttu.roman.dao.DAOTest;
import com.ttu.roman.model.invoice.Invoice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class InvoiceServiceTest extends DAOTest{
    @Autowired
    private InvoiceService invoiceService;

    @Test
    public void testCreateInvoice() throws Exception {
        Invoice invoice = invoiceService.createInvoice(serviceOrderDAO.find(64));
        assertEquals(1,invoice.getInvoiceRows().size());
        assertEquals(BigInteger.valueOf(12100), invoice.getPriceTotal());
    }
}