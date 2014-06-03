package com.ttu.roman.dao.invoice;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.invoice.Invoice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InvoiceDAO extends AbstractFacade<Invoice>{

    public InvoiceDAO() {
        super(Invoice.class);
    }
}
