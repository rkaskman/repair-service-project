package com.ttu.roman.dao.invoice;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.user.UserAccount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class InvoiceDAO extends AbstractFacade<Invoice>{

    public InvoiceDAO() {
        super(Invoice.class);
    }

    public Invoice findByServiceOrderId(Integer id){
        return em.createQuery("from Invoice i where i.serviceOrder.serviceOrder=:id", Invoice.class).
                setParameter("id", id).getSingleResult();
    }

    public List<Invoice> findCustomerInvoicesByCustomerId(Integer customerId) {
        return em.createQuery("from Invoice i where i.customerFk=:customerId", Invoice.class).
                setParameter("customerId", customerId).getResultList();
    }

}
