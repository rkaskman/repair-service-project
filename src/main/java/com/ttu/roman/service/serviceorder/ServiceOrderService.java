package com.ttu.roman.service.serviceorder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.form.serviceorder.AddServiceOrderForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ServiceOrderService {
    public static final int SO_STATUS_TYPE_SUBMITTED = 1;

    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @Autowired
    private DeviceDAO deviceDAO;

    public ServiceOrder saveNewServiceOrder(AddServiceOrderForm addServiceOrderForm) {
        final ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setServiceRequest(serviceRequestDAO.find(addServiceOrderForm.getServiceRequestId()));

        serviceOrder.setCreated(new Timestamp(System.currentTimeMillis()));
        //todo: uncomment when logged in
        //serviceOrder.setCreatedBy(((EmployeeUserAccount) getCurrentUser()).getEmployee().getEmployee());
        ServiceOrderStatusType serviceOrderStatusType = new ServiceOrderStatusType();
        serviceOrderStatusType.setSoStatusType(SO_STATUS_TYPE_SUBMITTED);
        serviceOrder.setServiceOrderStatusType(serviceOrderStatusType);

        serviceOrderDAO.create(serviceOrder);

        for (Integer integer : addServiceOrderForm.getDevices()) {
            Device device = deviceDAO.find(integer);
            device.getServiceOrders().add(serviceOrder);
            deviceDAO.update(device);
        }

        return serviceOrder;
    }

    public ServiceOrder saveUpdatedServiceOrder(AddServiceOrderForm addServiceOrderForm) {
        ServiceOrder serviceOrder = serviceOrderDAO.find(addServiceOrderForm.getServiceOrderId());
        final Set<Device> oldDevices = serviceOrder.getDevices();

        final Collection<Device> newDevices = Collections2.transform(addServiceOrderForm.getDevices(), new Function<Integer, Device>() {
            @Override
            public Device apply(Integer id) {
                return deviceDAO.find(id);
            }
        });

        Collection<Device> toDelete = Collections2.filter(oldDevices, new Predicate<Device>() {
            @Override
            public boolean apply(Device device) {
                return !newDevices.contains(device);
            }
        });

        Collection<Device> toAdd = Collections2.filter(newDevices, new Predicate<Device>() {
            @Override
            public boolean apply(Device device) {
                return !oldDevices.contains(device);
            }
        });


        for (Device device : toDelete) {
            device.getServiceOrders().remove(serviceOrder);
            deviceDAO.update(device);
        }

        for (Device device : toAdd) {
            device.getServiceOrders().add(serviceOrder);
            deviceDAO.update(device);
        }


        serviceOrder.setUpdated(new Timestamp(System.currentTimeMillis()));
        //todo: uncomment when logged in
//        serviceOrder.setUpdatedBy(((EmployeeUserAccount) getCurrentUser()).getEmployee().getEmployee());
        serviceOrderDAO.update(serviceOrder);

        return serviceOrder;
    }
}
