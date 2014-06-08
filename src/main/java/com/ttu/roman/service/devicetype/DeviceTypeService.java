package com.ttu.roman.service.devicetype;

import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceTypeService {
    @Autowired
    private DeviceTypeDAO deviceTypeDAO;

    public List<DeviceType> getOrderedDeviceTypes(){
        List<DeviceType> all = deviceTypeDAO.findAll();

        List<DeviceType> rootElements = new ArrayList<>();
        for (DeviceType deviceType : all) {
            if(deviceType.getLevel().equals(1)){
                rootElements.add(deviceType);
            }
        }

        List<DeviceType> orderedElements = new ArrayList<>();
        for (DeviceType rootElement : rootElements) {
            rootElement.setTypeName("--"+rootElement.getTypeName());
            orderedElements.add(rootElement);
            for (DeviceType deviceType : all) {
                if(rootElement.getDeviceType() == deviceType.getSuperTypeFk()){
                       deviceType.setTypeName("------" + deviceType.getTypeName());
                       orderedElements.add(deviceType);
                }
            }
        }

        return orderedElements;

    }

    public Map<Number, String> getDeviceTypeMap() {
        Map<Number, String> deviceTypes = new LinkedHashMap();
        for (DeviceType deviceType : getOrderedDeviceTypes()) {
            deviceTypes.put(deviceType.getDeviceType(), deviceType.getTypeName());
        }
        return  deviceTypes;
    }

}
