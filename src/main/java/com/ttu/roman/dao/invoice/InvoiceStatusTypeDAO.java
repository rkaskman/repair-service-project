package com.ttu.roman.dao.invoice;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.invoice.InvoiceRow;
import com.ttu.roman.model.invoice.InvoiceStatusType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InvoiceStatusTypeDAO extends AbstractFacade<InvoiceStatusType>{

    public InvoiceStatusTypeDAO() {
        super(InvoiceStatusType.class);
    }
}
