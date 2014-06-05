package com.ttu.roman.controller;

import com.ttu.roman.dao.invoice.InvoiceDAO;
import com.ttu.roman.dao.service.ServiceRequestDAO;
import com.ttu.roman.model.invoice.Invoice;
import com.ttu.roman.model.service.ServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("serviceRequest", new ServiceRequest());
        return "invoice/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost() {
        return "saved";
    }

}
