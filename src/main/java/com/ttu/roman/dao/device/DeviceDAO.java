package com.ttu.roman.dao.device;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.dao.user.CustomerDAO;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.user.AbstractCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class DeviceDAO extends AbstractFacade<Device>{

    @Autowired
    CustomerDAO customerDAO;

    public DeviceDAO() {
        super(Device.class);
    }
     //todo: maybe add customer-devices map?
   public List<Device> findDevicesByCustomerName(String name) {
       List<Device> devices = new ArrayList<Device>();

       List<AbstractCustomer> customers = customerDAO.findCustomersByName(name);

       for (AbstractCustomer customer : customers) {
           for(ServiceRequest serviceRequest : customer.getServiceRequests()) {
               for (ServiceOrder serviceOrder : serviceRequest.getServiceOrders()) {
                   devices.addAll(serviceOrder.getDevices());
               }
           }
       }

       return devices;
   }
}
