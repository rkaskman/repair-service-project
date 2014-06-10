package com.ttu.roman.service.serviceorder;

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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceOrderService {
    public static final int SO_STATUS_TYPE_SUBMITTED = 1;

    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @Autowired
    private DeviceDAO deviceDAO;

    public ServiceOrder saveNewServiceOrder(AddServiceOrderForm addServiceOrderForm){
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

}
