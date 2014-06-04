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

    @OneToMany(mappedBy = "serviceAction")
    private List<InvoiceRow> invoiceRows;

    @ManyToOne
    @JoinColumn(name = "service_action_status_type_fk")
    private ServiceActionStatusType serviceActionStatusType;

    @ManyToOne
    @JoinColumn(name = "service_type_fk")
    private  ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "service_order_fk")
    private  ServiceOrder serviceOrder;

    @Basic
    @Column(name = "service_device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceDeviceFk;

    @Basic
    @Column(name = "service_amount", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger serviceAmount;

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger price;

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


    public Integer getServiceDeviceFk() {
        return serviceDeviceFk;
    }

    public void setServiceDeviceFk(Integer serviceDeviceFk) {
        this.serviceDeviceFk = serviceDeviceFk;
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

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }
}
