package com.ttu.roman.model.service;

import com.ttu.roman.model.invoice.InvoiceRow;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "service_action", schema = "public", catalog = "ri")
public class ServiceAction {
    @Id
    @Column(name = "service_action", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceAction;

    @ManyToOne
    @JoinColumn(name = "service_action_status_type_fk")
    private ServiceActionStatusType serviceActionStatusType;

    @OneToMany(mappedBy = "serviceAction")
    private List<InvoiceRow> invoiceRows;

    @Basic
    @Column(name = "service_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceTypeFk;

    @Basic
    @Column(name = "service_device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceDeviceFk;

    @Basic
    @Column(name = "service_order_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceOrderFk;

    @Basic
    @Column(name = "service_amount", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger serviceAmount;

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger price;

    @Basic
    @Column(name = "price_updated", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp priceUpdated;

    @Basic
    @Column(name = "action_description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String actionDescription;

    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp created;

    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer createdBy;

    public int getServiceAction() {
        return serviceAction;
    }

    public void setServiceAction(int serviceAction) {
        this.serviceAction = serviceAction;
    }

    public Integer getServiceTypeFk() {
        return serviceTypeFk;
    }

    public void setServiceTypeFk(Integer serviceTypeFk) {
        this.serviceTypeFk = serviceTypeFk;
    }

    public Integer getServiceDeviceFk() {
        return serviceDeviceFk;
    }

    public void setServiceDeviceFk(Integer serviceDeviceFk) {
        this.serviceDeviceFk = serviceDeviceFk;
    }

    public Integer getServiceOrderFk() {
        return serviceOrderFk;
    }

    public void setServiceOrderFk(Integer serviceOrderFk) {
        this.serviceOrderFk = serviceOrderFk;
    }

    public BigInteger getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigInteger serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Timestamp getPriceUpdated() {
        return priceUpdated;
    }

    public void setPriceUpdated(Timestamp priceUpdated) {
        this.priceUpdated = priceUpdated;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ServiceActionStatusType getServiceActionStatusType() {
        return serviceActionStatusType;
    }

    public void setServiceActionStatusType(ServiceActionStatusType serviceActionStatusType) {
        this.serviceActionStatusType = serviceActionStatusType;
    }

    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }
}
