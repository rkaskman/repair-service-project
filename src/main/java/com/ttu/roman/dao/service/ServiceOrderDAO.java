package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ServiceOrderDAO extends AbstractFacade<ServiceOrder>{

    public ServiceOrderDAO() {
        super(ServiceOrder.class);
    }

    public List<ServiceOrder> findByServiceRequestId(Integer id){
        return em.createQuery("from ServiceOrder s where s.serviceRequest.serviceRequest=:id", ServiceOrder.class).
                setParameter("id", id).getResultList();
    }

    public List<ServiceOrder> findCustomerOrdersByCustomerId(Integer customerId) {
        return em.createQuery("from ServiceOrder s where s.serviceRequest.customer.customer=:customerId").
                setParameter("customerId", customerId).getResultList();
    }
}
