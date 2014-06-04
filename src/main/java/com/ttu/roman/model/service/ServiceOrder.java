package com.ttu.roman.model.service;

import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.invoice.Invoice;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "service_order", schema = "public", catalog = "ri")
public class ServiceOrder {

    @Id
    @Column(name = "service_order", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceOrder;

    @ManyToMany(mappedBy = "serviceOrders")
    private List<Device> devices;

    @OneToMany(mappedBy = "serviceOrder")
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "serviceOrder")
    private List<ServiceAction> serviceActions;

    @OneToMany(mappedBy = "serviceOrder")
    private List<ServicePart> serviceParts;

    @ManyToOne
    @JoinColumn(name="so_status_type_fk")
    private ServiceOrderStatusType serviceOrderStatusType;

    @ManyToOne
    @JoinColumn(name="service_request_fk")
    private ServiceRequest serviceRequest;

    @Basic
    @Column(name = "status_changed_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer statusChangedBy;

    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer createdBy;

    @Basic
    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer updatedBy;

    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp created;

    @Basic
    @Column(name = "updated", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp updated;

    @Basic
    @Column(name = "status_changed", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp statusChanged;

    @Basic
    @Column(name = "price_total", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger priceTotal;

    @Basic
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String note;

    public int getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(int serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Timestamp getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(Timestamp statusChanged) {
        this.statusChanged = statusChanged;
    }

    public Integer getStatusChangedBy() {
        return statusChangedBy;
    }

    public void setStatusChangedBy(Integer statusChangedBy) {
        this.statusChangedBy = statusChangedBy;
    }

    public BigInteger getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigInteger priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ServiceOrderStatusType getServiceOrderStatusType() {
        return serviceOrderStatusType;
    }

    public void setServiceOrderStatusType(ServiceOrderStatusType serviceOrderStatusType) {
        this.serviceOrderStatusType = serviceOrderStatusType;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<ServiceAction> getServiceActions() {
        return serviceActions;
    }

    public void setServiceActions(List<ServiceAction> serviceActions) {
        this.serviceActions = serviceActions;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public List<ServicePart> getServiceParts() {
        return serviceParts;
    }

    public void setServiceParts(List<ServicePart> serviceParts) {
        this.serviceParts = serviceParts;
    }
}
