package com.ttu.roman.form.invoice;

import com.ttu.roman.model.invoice.Invoice;


public class UpdateInvoiceForm {

    private Invoice invoice;
    private Integer invoiceStatusType;

    public Invoice getInvoice() {
        return invoice;
    }

    public Integer getInvoiceStatusType() {
        return invoiceStatusType;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void setInvoiceStatusType(Integer invoiceStatusType) {
        this.invoiceStatusType = invoiceStatusType;
    }
}
