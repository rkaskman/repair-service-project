package com.ttu.roman.model.invoice;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "invoice_status_type", schema = "public", catalog = "ri")
public class InvoiceStatusType {
    @Id
    @Column(name = "invoice_status_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int invoiceStatusType;

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String typeName;

    @OneToMany(mappedBy = "invoiceStatusType")
    private List<Invoice> invoices;

    public int getInvoiceStatusType() {
        return invoiceStatusType;
    }

    public void setInvoiceStatusType(int invoiceStatusType) {
        this.invoiceStatusType = invoiceStatusType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
