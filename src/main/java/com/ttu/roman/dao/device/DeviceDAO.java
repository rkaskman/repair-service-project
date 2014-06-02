package com.ttu.roman.dao.device;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.model.device.Device;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DeviceDAO extends AbstractFacade<Device>{

    public DeviceDAO() {
        super(Device.class);
    }
}
