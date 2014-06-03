package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceDevice;
import com.ttu.roman.model.service.ServiceOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceDeviceDAO extends AbstractFacade<ServiceDevice>{

    public ServiceDeviceDAO() {
        super(ServiceDevice.class);
    }
}
