package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceType;
import com.ttu.roman.model.service.ServiceUnitType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceUnitTypeDAO extends AbstractFacade<ServiceUnitType>{

    public ServiceUnitTypeDAO() {
        super(ServiceUnitType.class);
    }
}
