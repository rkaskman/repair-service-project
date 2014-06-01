package com.ttu.roman.model;

import javax.persistence.*;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "invoice_status_type", schema = "public", catalog = "ri")
public class InvoiceStatusTypeEntity {
    private int invoiceStatusType;
    private String typeName;

    @Id
    @Column(name = "invoice_status_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getInvoiceStatusType() {
        return invoiceStatusType;
    }

    public void setInvoiceStatusType(int invoiceStatusType) {
        this.invoiceStatusType = invoiceStatusType;
    }

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceStatusTypeEntity that = (InvoiceStatusTypeEntity) o;

        if (invoiceStatusType != that.invoiceStatusType) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceStatusType;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
