package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceTypeDAO extends AbstractFacade<ServiceType>{

    public ServiceTypeDAO() {
        super(ServiceType.class);
    }
}
