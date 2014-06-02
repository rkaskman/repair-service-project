package com.ttu.roman.dao.invoice;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.invoice.InvoiceRow;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InvoiceRowDAO extends AbstractFacade<InvoiceRow>{

    public InvoiceRowDAO() {
        super(InvoiceRow.class);
    }
}
