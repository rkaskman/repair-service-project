package com.ttu.roman.controller;

import com.ttu.roman.dao.invoice.InvoiceDAO;
import com.ttu.roman.dao.invoice.InvoiceStatusTypeDAO;
import com.ttu.roman.dao.service.ServiceOrderDAO;
import com.ttu.roman.model.service.ServiceRequest;
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

    @RequestMapping("/update")
    public String add(Model model, @RequestParam(required = true) Integer serviceOrderId) {
        model.addAttribute("invoice", serviceOrderDAO.find(serviceOrderId).getInvoice());
        model.addAttribute("invoiceStatusTypes", invoiceStatusTypeDAO.findAll());
        return "invoice/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String addPost() {
        return "saved";
    }

}
