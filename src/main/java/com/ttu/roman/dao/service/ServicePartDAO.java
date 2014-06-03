package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServicePart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServicePartDAO extends AbstractFacade<ServicePart>{

    public ServicePartDAO() {
        super(ServicePart.class);
    }
}
