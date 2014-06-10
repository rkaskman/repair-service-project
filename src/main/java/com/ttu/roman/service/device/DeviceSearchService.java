package com.ttu.roman.service.device;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.form.device.SearchDeviceForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeviceSearchService {
    @Autowired
    private DeviceTypeDAO deviceTypeDAO;

    @Autowired
    private DeviceDAO deviceDAO;


    public Collection<SearchDeviceForm> getOrderedDeviceTypes(SearchDeviceForm searchDeviceForm){
        String name = searchDeviceForm.getDevice().getName();
        String deviceModel = searchDeviceForm.getDevice().getModel();
        String regNo = searchDeviceForm.getDevice().getRegNo();
        String clientName = searchDeviceForm.getClientName();


        DeviceType deviceType = deviceTypeDAO.find(searchDeviceForm.getDeviceTypeId());

        Set<Device> searchResult = new HashSet<>();
        if(deviceType.getLevel() == 2) {
            searchResult = deviceType.getDevices();
        }else {
            List<DeviceType> deviceTypesBySuperDeviceId = deviceTypeDAO.findDeviceTypesBySuperDeviceId(deviceType.getDeviceType());
            for (DeviceType type : deviceTypesBySuperDeviceId) {
                searchResult.addAll(type.getDevices());
            }
        }


        if(!name.isEmpty()){
            searchResult.retainAll(deviceDAO.findDeviceByName(name));
        }

        if(!deviceModel.isEmpty()){
            searchResult.retainAll(deviceDAO.findDeviceByModel(deviceModel));
        }

        if(!regNo.isEmpty()){
            searchResult.retainAll(deviceDAO.findDeviceByRegNo(regNo));
        }

        if(!clientName.isEmpty()){
            searchResult.retainAll(deviceDAO.findDevicesByCustomerName(clientName));
        }

        Collection<SearchDeviceForm> result = Collections2.transform(searchResult, new Function<Device, SearchDeviceForm>() {
            @Override
            public SearchDeviceForm apply(Device device) {
                return mapDeviceSearchResponse(device);
            }
        });

        return result;

    }

    private SearchDeviceForm mapDeviceSearchResponse(Device device) {
        SearchDeviceForm deviceResponse = new SearchDeviceForm();
        Device responseDevice = deviceResponse.getDevice();
        responseDevice.setDescription(device.getDescription());
        responseDevice.setName(device.getName());
        responseDevice.setRegNo(device.getRegNo());
        responseDevice.setModel(device.getModel());
        responseDevice.setDevice(device.getDevice());

        return deviceResponse;
    }

}
