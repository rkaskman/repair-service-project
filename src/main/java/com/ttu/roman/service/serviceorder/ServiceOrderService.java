package com.ttu.roman.service.serviceorder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.dao.service.ServiceNoteDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceOrderStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.form.serviceorder.AddServiceOrderForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.model.service.*;
import com.ttu.roman.model.user.EmployeeUserAccount;
import com.ttu.roman.model.user.UserAccount;
import com.ttu.roman.service.userlogin.UserAccountUtil;
import com.ttu.roman.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.*;

import static com.ttu.roman.util.Util.isEmptyOrOnlyWhiteSpaces;
import static java.math.BigInteger.valueOf;

@Service
public class ServiceOrderService {
    public static final int SO_STATUS_TYPE_SUBMITTED = 1;

    @Autowired
    private ServiceRequestDAO serviceRequestDAO;

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @Autowired
    private DeviceDAO deviceDAO;

    @Autowired
    private ServiceNoteDAO serviceNoteDAO;

    @Autowired
    private ServiceOrderStatusTypeDAO serviceOrderStatusTypeDAO;

    public ServiceOrder saveNewServiceOrder(AddServiceOrderForm addServiceOrderForm) {
        final ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setServiceRequest(serviceRequestDAO.find(addServiceOrderForm.getServiceRequestId()));
        serviceOrder.setNote(addServiceOrderForm.getNote());

        serviceOrder.setCreatedBy(((EmployeeUserAccount) UserAccountUtil.getCurrentUser()).getEmployee().getEmployee());
        ServiceOrderStatusType serviceOrderStatusType = new ServiceOrderStatusType();
        serviceOrderStatusType.setSoStatusType(SO_STATUS_TYPE_SUBMITTED);
        serviceOrder.setServiceOrderStatusType(serviceOrderStatusType);

        serviceOrder.setCreated(new Timestamp(System.currentTimeMillis()));

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

        serviceOrder.setServiceOrderStatusType(serviceOrderStatusTypeDAO.find(addServiceOrderForm.getServiceOrderStatusType()));

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

        serviceOrder.setNote(addServiceOrderForm.getNote());

        if(!isEmptyOrOnlyWhiteSpaces(addServiceOrderForm.getEmployeeNote())) {
            ServiceNote serviceNote = createServiceNote(serviceOrder, addServiceOrderForm.getEmployeeNote());
            serviceNoteDAO.create(serviceNote);
        }
        serviceOrder.setUpdated(new Timestamp(System.currentTimeMillis()));
        serviceOrder.setUpdatedBy(((EmployeeUserAccount) UserAccountUtil.getCurrentUser()).getEmployee().getEmployee());
        serviceOrderDAO.update(serviceOrder);

        return serviceOrder;
    }

    private ServiceNote createServiceNote(ServiceOrder serviceOrder, String employeeNote) {
        ServiceNote serviceNote = new ServiceNote();
        serviceNote.setEmployee(((EmployeeUserAccount) UserAccountUtil.getCurrentUser()).getEmployee());
        serviceNote.setNote(employeeNote);
        serviceNote.setCreated(new Timestamp(System.currentTimeMillis()));
        serviceNote.setServiceOrder(serviceOrder);
        serviceNote.setNoteAuthorType(2);

        return serviceNote;
    }

    public BigInteger getServiceOrderCurrentCost(ServiceOrder serviceOrder) {
        BigInteger currentCost = BigInteger.ZERO;

        for (ServiceAction serviceAction : serviceOrder.getServiceActions()) {
            currentCost = currentCost.add(serviceAction.getPrice().multiply(serviceAction.getServiceAmount()));
        }

        for (ServicePart servicePart : serviceOrder.getServiceParts()) {
            currentCost = currentCost.add(servicePart.getPartPrice().multiply(valueOf(servicePart.getPartCount())));
        }

        return currentCost;
    }
}
