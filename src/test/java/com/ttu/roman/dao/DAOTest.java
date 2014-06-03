package com.ttu.roman.dao;

import com.ttu.roman.TestContext;
import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.device.DeviceTypeDAO;
import com.ttu.roman.dao.invoice.InvoiceDAO;
import com.ttu.roman.dao.invoice.InvoiceRowDAO;
import com.ttu.roman.dao.invoice.InvoiceStatusTypeDAO;
import com.ttu.roman.dao.service.*;
import com.ttu.roman.model.device.DeviceType;
import com.ttu.roman.model.invoice.InvoiceRow;
import com.ttu.roman.model.invoice.InvoiceStatusType;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServicePart;
import com.ttu.roman.model.service.ServiceRequestStatusType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
}
