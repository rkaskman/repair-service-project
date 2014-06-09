package com.ttu.roman.model.invoice;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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
    private Set<Invoice> invoices;

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

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceStatusType that = (InvoiceStatusType) o;

        if (invoiceStatusType != that.invoiceStatusType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return invoiceStatusType;
    }
}
