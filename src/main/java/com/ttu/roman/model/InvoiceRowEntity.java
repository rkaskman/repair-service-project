package com.ttu.roman.model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "invoice_row", schema = "public", catalog = "ri")
public class InvoiceRowEntity {
    private int invoiceRow;
    private Integer invoiceFk;
    private Integer serviceActionFk;
    private Integer servicePartFk;
    private String actionPartDescription;
    private BigInteger amount;
    private BigInteger priceTotal;
    private String unitType;
    private BigInteger unitPrice;
    private BigInteger invoiceRowType;

    @Id
    @Column(name = "invoice_row", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getInvoiceRow() {
        return invoiceRow;
    }

    public void setInvoiceRow(int invoiceRow) {
        this.invoiceRow = invoiceRow;
    }

    @Basic
    @Column(name = "invoice_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getInvoiceFk() {
        return invoiceFk;
    }

    public void setInvoiceFk(Integer invoiceFk) {
        this.invoiceFk = invoiceFk;
    }

    @Basic
    @Column(name = "service_action_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceActionFk() {
        return serviceActionFk;
    }

    public void setServiceActionFk(Integer serviceActionFk) {
        this.serviceActionFk = serviceActionFk;
    }

    @Basic
    @Column(name = "service_part_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServicePartFk() {
        return servicePartFk;
    }

    public void setServicePartFk(Integer servicePartFk) {
        this.servicePartFk = servicePartFk;
    }

    @Basic
    @Column(name = "action_part_description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getActionPartDescription() {
        return actionPartDescription;
    }

    public void setActionPartDescription(String actionPartDescription) {
        this.actionPartDescription = actionPartDescription;
    }

    @Basic
    @Column(name = "amount", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "price_total", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    public BigInteger getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigInteger priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Basic
    @Column(name = "unit_type", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "unit_price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "invoice_row_type", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public BigInteger getInvoiceRowType() {
        return invoiceRowType;
    }

    public void setInvoiceRowType(BigInteger invoiceRowType) {
        this.invoiceRowType = invoiceRowType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceRowEntity that = (InvoiceRowEntity) o;

        if (invoiceRow != that.invoiceRow) return false;
        if (actionPartDescription != null ? !actionPartDescription.equals(that.actionPartDescription) : that.actionPartDescription != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (invoiceFk != null ? !invoiceFk.equals(that.invoiceFk) : that.invoiceFk != null) return false;
        if (invoiceRowType != null ? !invoiceRowType.equals(that.invoiceRowType) : that.invoiceRowType != null)
            return false;
        if (priceTotal != null ? !priceTotal.equals(that.priceTotal) : that.priceTotal != null) return false;
        if (serviceActionFk != null ? !serviceActionFk.equals(that.serviceActionFk) : that.serviceActionFk != null)
            return false;
        if (servicePartFk != null ? !servicePartFk.equals(that.servicePartFk) : that.servicePartFk != null)
            return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (unitType != null ? !unitType.equals(that.unitType) : that.unitType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoiceRow;
        result = 31 * result + (invoiceFk != null ? invoiceFk.hashCode() : 0);
        result = 31 * result + (serviceActionFk != null ? serviceActionFk.hashCode() : 0);
        result = 31 * result + (servicePartFk != null ? servicePartFk.hashCode() : 0);
        result = 31 * result + (actionPartDescription != null ? actionPartDescription.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (priceTotal != null ? priceTotal.hashCode() : 0);
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (invoiceRowType != null ? invoiceRowType.hashCode() : 0);
        return result;
    }
}
