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

    public ServiceDevice findByServiceOrderAndDevice(int serviceOrderId, int deviceId) {
       return em.createQuery("select sd from ServiceDevice sd where sd.device.device=:deviceId and sd.serviceOrder.serviceOrder=:serviceOrderId", ServiceDevice.class).
                setParameter("serviceOrderId", serviceOrderId).setParameter("deviceId", deviceId).getSingleResult();
    }
}
