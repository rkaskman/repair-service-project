package com.ttu.roman.dao;

import com.ttu.roman.TestContext;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.dao.invoice.InvoiceDAO;
import com.ttu.roman.dao.invoice.InvoiceRowDAO;
import com.ttu.roman.dao.invoice.InvoiceStatusTypeDAO;
import com.ttu.roman.dao.service.*;
import com.ttu.roman.dao.userlogin.UserAccountDAO;
import com.ttu.roman.model.service.ServiceType;
import com.ttu.roman.model.service.ServiceUnitType;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@Transactional
public abstract class DAOTest {

    @Autowired
    public InvoiceDAO invoiceDAO;

    @Autowired
    public InvoiceRowDAO invoiceRowDAO;

    @Autowired
    public InvoiceStatusTypeDAO invoiceStatusTypeDAO;

    @Autowired
    public DeviceDAO deviceDAO;

    @Autowired
    public DeviceTypeDAO deviceTypeDAO;

    @Autowired
    public ServiceOrderDAO serviceOrderDAO;

    @Autowired
    public ServiceOrderStatusTypeDAO serviceOrderStatusTypeDAO;

    @Autowired
    public ServiceRequestDAO serviceRequestDAO;

    @Autowired
    public ServiceRequestStatusTypeDAO serviceRequestStatusTypeDAO;;

    @Autowired
    public ServicePartDAO servicePartDAO;

    @Autowired
    public ServiceDeviceDAO serviceDeviceDAO;

    @Autowired
    public  ServiceDeviceStatusTypeDAO serviceDeviceStatusTypeDAO;

    @Autowired
    public ServiceActionDAO serviceActionDAO;

    @Autowired
    public ServiceActionStatusTypeDAO serviceActionStatusTypeDAO;

    @Autowired
    public UserAccountDAO userAccountDAO;

    @Autowired
    public ServiceTypeDAO serviceTypeDAO;

    @Autowired
    public ServiceUnitTypeDAO serviceUnitTypeDAO;

    @Autowired
    public ServiceNoteDAO serviceNoteDAO;
}
