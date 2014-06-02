package com.ttu.roman.model.invoice;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "invoice", schema = "public", catalog = "ri")
public class Invoice {


    @Id
    @Column(name = "invoice", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int invoice;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceRow> invoiceRows;

    @Basic
    @Column(name = "invoice_status_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer invoiceStatusTypeFk;

    @Basic
    @Column(name = "service_order_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceOrderFk;

    @Basic
    @Column(name = "customer_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer customerFk;

    @Basic
    @Column(name = "invoice_date", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    private Date invoiceDate;

    @Basic
    @Column(name = "due_date", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    private Date dueDate;

    @Basic
    @Column(name = "price_total", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger priceTotal;

    @Basic
    @Column(name = "receiver_name", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String receiverName;

    @Basic
    @Column(name = "reference_number", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String referenceNumber;

    @Basic
    @Column(name = "receiver_accounts", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String receiverAccounts;

    @Basic
    @Column(name = "payment_date", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    private Date paymentDate;

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String description;

    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public Integer getInvoiceStatusTypeFk() {
        return invoiceStatusTypeFk;
    }

    public void setInvoiceStatusTypeFk(Integer invoiceStatusTypeFk) {
        this.invoiceStatusTypeFk = invoiceStatusTypeFk;
    }

    public Integer getServiceOrderFk() {
        return serviceOrderFk;
    }

    public void setServiceOrderFk(Integer serviceOrderFk) {
        this.serviceOrderFk = serviceOrderFk;
    }

    public Integer getCustomerFk() {
        return customerFk;
    }

    public void setCustomerFk(Integer customerFk) {
        this.customerFk = customerFk;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigInteger getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigInteger priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getReceiverAccounts() {
        return receiverAccounts;
    }

    public void setReceiverAccounts(String receiverAccounts) {
        this.receiverAccounts = receiverAccounts;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice that = (Invoice) o;

        if (invoice != that.invoice) return false;
        if (customerFk != null ? !customerFk.equals(that.customerFk) : that.customerFk != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null) return false;
        if (invoiceStatusTypeFk != null ? !invoiceStatusTypeFk.equals(that.invoiceStatusTypeFk) : that.invoiceStatusTypeFk != null)
            return false;
        if (paymentDate != null ? !paymentDate.equals(that.paymentDate) : that.paymentDate != null) return false;
        if (priceTotal != null ? !priceTotal.equals(that.priceTotal) : that.priceTotal != null) return false;
        if (receiverAccounts != null ? !receiverAccounts.equals(that.receiverAccounts) : that.receiverAccounts != null)
            return false;
        if (receiverName != null ? !receiverName.equals(that.receiverName) : that.receiverName != null) return false;
        if (referenceNumber != null ? !referenceNumber.equals(that.referenceNumber) : that.referenceNumber != null)
            return false;
        if (serviceOrderFk != null ? !serviceOrderFk.equals(that.serviceOrderFk) : that.serviceOrderFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoice;
        result = 31 * result + (invoiceStatusTypeFk != null ? invoiceStatusTypeFk.hashCode() : 0);
        result = 31 * result + (serviceOrderFk != null ? serviceOrderFk.hashCode() : 0);
        result = 31 * result + (customerFk != null ? customerFk.hashCode() : 0);
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (priceTotal != null ? priceTotal.hashCode() : 0);
        result = 31 * result + (receiverName != null ? receiverName.hashCode() : 0);
        result = 31 * result + (referenceNumber != null ? referenceNumber.hashCode() : 0);
        result = 31 * result + (receiverAccounts != null ? receiverAccounts.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
