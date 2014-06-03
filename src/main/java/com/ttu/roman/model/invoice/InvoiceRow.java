package com.ttu.roman.model.invoice;

import com.ttu.roman.model.service.ServiceAction;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "invoice_row", schema = "public", catalog = "ri")
public class InvoiceRow {
    @Id
    @Column(name = "invoice_row", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int invoiceRow;

    @ManyToOne
    @JoinColumn(name="invoice_fk")
    private Invoice invoice;

//    @Basic
//    @Column(name = "service_action_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
//    private Integer serviceActionFk;

    @ManyToOne
    @JoinColumn(name="service_action_fk")
    private ServiceAction serviceAction;

    @Basic
    @Column(name = "service_part_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer servicePartFk;

    @Basic
    @Column(name = "action_part_description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String actionPartDescription;

    @Basic
    @Column(name = "amount", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger amount;

    @Basic
    @Column(name = "price_total", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger priceTotal;

    @Basic
    @Column(name = "unit_type", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String unitType;

    @Basic
    @Column(name = "unit_price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger unitPrice;

    @Basic
    @Column(name = "invoice_row_type", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    private BigInteger invoiceRowType;

    public int getInvoiceRow() {
        return invoiceRow;
    }

    public void setInvoiceRow(int invoiceRow) {
        this.invoiceRow = invoiceRow;
    }


    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

//    public Integer getServiceActionFk() {
//        return serviceActionFk;
//    }
//
//    public void setServiceActionFk(Integer serviceActionFk) {
//        this.serviceActionFk = serviceActionFk;
//    }

    public Integer getServicePartFk() {
        return servicePartFk;
    }

    public void setServicePartFk(Integer servicePartFk) {
        this.servicePartFk = servicePartFk;
    }

    public String getActionPartDescription() {
        return actionPartDescription;
    }

    public void setActionPartDescription(String actionPartDescription) {
        this.actionPartDescription = actionPartDescription;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigInteger priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getInvoiceRowType() {
        return invoiceRowType;
    }

    public void setInvoiceRowType(BigInteger invoiceRowType) {
        this.invoiceRowType = invoiceRowType;
    }

    public ServiceAction getServiceAction() {
        return serviceAction;
    }

    public void setServiceAction(ServiceAction serviceActionPart) {
        this.serviceAction = serviceActionPart;
    }
}
