package com.ttu.roman.dao.device;


import com.ttu.roman.dao.abstractions.AbstractFacade;
import com.ttu.roman.dao.user.CustomerDAO;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceRequest;
import com.ttu.roman.model.user.AbstractCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class DeviceDAO extends AbstractFacade<Device>{

    @Autowired
    CustomerDAO customerDAO;

    public DeviceDAO() {
        super(Device.class);
    }
   public List<Device> findDevicesByCustomerName(String name) {
       List<Device> devices = new ArrayList<Device>();

       List<AbstractCustomer> customers = customerDAO.findCustomersByName(name);

       for (AbstractCustomer customer : customers) {
           for(ServiceRequest serviceRequest : customer.getServiceRequests()) {
               ServiceOrder serviceOrder = serviceRequest.getServiceOrder();
               if(serviceOrder != null) {
                   devices.addAll(serviceOrder.getDevices());
               }
           }
       }

       return devices;
   }

    public List<Device> findDeviceByName(String nameOfDevice){
            return em.createQuery("from Device d where d.name like :nameOfDevice", Device.class).
                    setParameter("nameOfDevice", "%"+nameOfDevice+"%").getResultList();
    }

    public List<Device> findDeviceByModel(String nameOfModel){
            return em.createQuery("from Device d where d.model like :nameOfModel", Device.class).
                    setParameter("nameOfModel", "%" + nameOfModel + "%").getResultList();
    }

    public List<Device> findDeviceByRegNo(String regNo){
            return em.createQuery("from Device d where d.regNo like :regNo", Device.class).
                    setParameter("regNo", "%" + regNo + "%").getResultList();
    }
}
