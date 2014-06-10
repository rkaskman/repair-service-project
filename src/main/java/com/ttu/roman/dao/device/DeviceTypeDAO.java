package com.ttu.roman.dao.device;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class DeviceTypeDAO extends AbstractFacade<DeviceType>{

    public DeviceTypeDAO() {
        super(DeviceType.class);
    }

    public List<DeviceType> findDeviceTypesBySuperDeviceId(Integer superDeviceTypeId){
        return em.createQuery("from DeviceType d where d.superTypeFk =:superDeviceTypeId", DeviceType.class).
                setParameter("superDeviceTypeId", superDeviceTypeId).getResultList();
    }
}
