package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceRequestStatusTypeDAO extends AbstractFacade<ServiceRequestStatusType>{

    public ServiceRequestStatusTypeDAO() {
        super(ServiceRequestStatusType.class);
    }
}
