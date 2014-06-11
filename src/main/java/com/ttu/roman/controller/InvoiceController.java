package com.ttu.roman.controller;

import com.ttu.roman.dao.invoice.InvoiceDAO;
import com.ttu.roman.dao.invoice.InvoiceStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.form.invoice.UpdateInvoiceForm;
import com.ttu.roman.model.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private ServiceOrderDAO serviceOrderDAO;

    @Autowired
    private InvoiceStatusTypeDAO invoiceStatusTypeDAO;

    @Autowired
    private InvoiceDAO invoiceDAO;

    @RequestMapping("/update")
    public String add(Model model, @RequestParam(required = true) Integer serviceOrderId) {
        Invoice invoice = serviceOrderDAO.find(serviceOrderId).getInvoice();

        UpdateInvoiceForm updateInvoiceForm = new UpdateInvoiceForm();
        updateInvoiceForm.setInvoice(invoice);

        model.addAttribute("invoice", invoice);
        model.addAttribute("updateInvoiceForm", updateInvoiceForm);
        model.addAttribute("invoiceStatusTypes", invoiceStatusTypeDAO.findAll());
        return "invoice/update";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addPost(Model model, UpdateInvoiceForm updateInvoiceForm) {
        Invoice invoiceFromForm = updateInvoiceForm.getInvoice();

        Invoice originalInvoice = invoiceDAO.find(invoiceFromForm.getInvoice());
        originalInvoice.setDescription(invoiceFromForm.getDescription());
        originalInvoice.setReferenceNumber(invoiceFromForm.getReferenceNumber());
        originalInvoice.setReceiverAccounts(invoiceFromForm.getReceiverAccounts());
        originalInvoice.setReceiverName(invoiceFromForm.getReceiverName());
        originalInvoice.setInvoiceStatusType(invoiceStatusTypeDAO.find(updateInvoiceForm.getInvoiceStatusType()));


        invoiceDAO.update(originalInvoice);
        return "redirect:/invoice/update?serviceOrderId="+originalInvoice.getServiceOrder().getServiceOrder();
    }

}
