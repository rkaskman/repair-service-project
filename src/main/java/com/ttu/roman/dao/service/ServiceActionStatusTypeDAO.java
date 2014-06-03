package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceActionStatusType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceActionStatusTypeDAO extends AbstractFacade<ServiceActionStatusType>{

    public ServiceActionStatusTypeDAO() {
        super(ServiceActionStatusType.class);
    }
}
