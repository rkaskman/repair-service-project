package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceDevice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceActionDAO extends AbstractFacade<ServiceAction>{

    public ServiceActionDAO() {
        super(ServiceAction.class);
    }
}
