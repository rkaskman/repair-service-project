package com.ttu.roman.dao.service;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.service.ServiceDevice;
import com.ttu.roman.model.service.ServiceDeviceStatusType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceDeviceStatusTypeDAO extends AbstractFacade<ServiceDeviceStatusType>{

    public ServiceDeviceStatusTypeDAO() {
        super(ServiceDeviceStatusType.class);
    }
}
