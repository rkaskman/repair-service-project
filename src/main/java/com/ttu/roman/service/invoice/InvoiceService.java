package com.ttu.roman.service.invoice;

import com.ttu.roman.dao.device.DeviceDAO;
import com.ttu.roman.dao.invoice.InvoiceDAO;
import com.ttu.roman.dao.invoice.InvoiceRowDAO;
import com.ttu.roman.dao.invoice.InvoiceStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.form.invoice.UpdateInvoiceForm;
import com.ttu.roman.form.serviceorder.AddServiceOrderForm;
import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.invoice.InvoiceRow;
import com.ttu.roman.model.service.ServiceAction;
import com.ttu.roman.model.service.ServiceOrder;
import com.ttu.roman.model.service.ServiceOrderStatusType;
import com.ttu.roman.model.service.ServicePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private InvoiceStatusTypeDAO invoiceStatusTypeDAO;

    @Autowired
    private InvoiceRowDAO invoiceRowDAO;

    public Invoice createInvoice(ServiceOrder serviceOrder) throws Exception {
        Invoice invoice = new Invoice();
        invoiceDAO.create(invoice);

        for (ServicePart servicePart : serviceOrder.getServiceParts()) {
            InvoiceRow invoiceRow = new InvoiceRow();
            invoiceRow.setServicePart(servicePart);
            invoiceRow.setUnitPrice(servicePart.getPartPrice());
            invoiceRow.setUnitType("tk.");
            invoiceRow.setAmount(BigInteger.valueOf(servicePart.getPartCount()));
            invoiceRow.setPriceTotal(servicePart.getPartPrice().multiply(BigInteger.valueOf(servicePart.getPartCount())));
            invoiceRow.setInvoice(invoice);
            invoiceRow.setActionPartDescription(servicePart.getPartName());
            invoiceRowDAO.create(invoiceRow);
            invoice.getInvoiceRows().add(invoiceRow);
        }

        for (ServiceAction serviceAction : serviceOrder.getServiceActions()) {
            InvoiceRow invoiceRow = new InvoiceRow();
            invoiceRow.setServiceAction(serviceAction);
            invoiceRow.setUnitPrice(serviceAction.getPrice());
            invoiceRow.setUnitType(serviceAction.getServiceType().getServiceUnitType().getTypeName());
            invoiceRow.setAmount(serviceAction.getServiceAmount());
            invoiceRow.setPriceTotal(
                    serviceAction.getPrice().multiply(
                            serviceAction.getServiceAmount()).multiply(
                                serviceAction.getServiceType().getServicePrice()));
            invoiceRow.setInvoice(invoice);
            invoiceRow.setActionPartDescription(serviceAction.getActionDescription());
            invoiceRowDAO.create(invoiceRow);
            invoice.getInvoiceRows().add(invoiceRow);
        }

        BigInteger totalPriveOfInvoice = BigInteger.ZERO;
        for (InvoiceRow invoiceRow : invoice.getInvoiceRows()) {
            BigInteger price = invoiceRow.getPriceTotal();
            totalPriveOfInvoice = totalPriveOfInvoice.add(price);
        }

        invoice.setInvoiceStatusType(invoiceStatusTypeDAO.find(1));
        invoice.setPriceTotal(totalPriveOfInvoice);
        invoice.setServiceOrder(serviceOrder);
        invoiceDAO.update(invoice);

        return invoice;
    }

    public Invoice updateInvoice(UpdateInvoiceForm updateInvoiceForm) {
        Invoice invoiceFromForm = updateInvoiceForm.getInvoice();

        Invoice originalInvoice = invoiceDAO.find(invoiceFromForm.getInvoice());
        originalInvoice.setDescription(invoiceFromForm.getDescription());
        originalInvoice.setReferenceNumber(invoiceFromForm.getReferenceNumber());
        originalInvoice.setReceiverAccounts(invoiceFromForm.getReceiverAccounts());
        originalInvoice.setReceiverName(invoiceFromForm.getReceiverName());
        originalInvoice.setInvoiceStatusType(invoiceStatusTypeDAO.find(updateInvoiceForm.getInvoiceStatusType()));

        invoiceDAO.update(originalInvoice);
        return originalInvoice;
    }

}
