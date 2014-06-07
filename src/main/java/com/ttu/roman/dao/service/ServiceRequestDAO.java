package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.service.ServiceRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceRequestDAO extends AbstractFacade<ServiceRequest>{

    public ServiceRequestDAO() {
        super(ServiceRequest.class);
    }


}
