package com.ttu.roman.model.service;

import com.ttu.roman.model.device.Device;
import com.ttu.roman.model.invoice.Invoice;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "service_order", schema = "public", catalog = "ri")
@Cacheable(false)
public class ServiceOrder {

    @Id
    @SequenceGenerator(name="service_order_id", initialValue=4, allocationSize=1, schema = "public", catalog = "ri", sequenceName = "service_order_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "service_order_id")
    @Column(name = "service_order", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceOrder;

    @ManyToMany(mappedBy = "serviceOrders" , fetch = FetchType.EAGER)
    private Set<Device> devices = new HashSet<>();

    @OneToOne(mappedBy = "serviceOrder"  , fetch = FetchType.EAGER)
    private Invoice invoice;

    @OneToMany(mappedBy = "serviceOrder"  , fetch = FetchType.EAGER)
    private Set<ServiceAction> serviceActions = new HashSet<>();

    @OneToMany(mappedBy = "serviceOrder"  , fetch = FetchType.EAGER)
    private Set<ServicePart> serviceParts = new HashSet<>();

    @OneToMany(mappedBy = "serviceOrder"  , fetch = FetchType.EAGER)
    private Set<ServiceNote> serviceNotes = new HashSet<>();

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

    public Integer getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(Integer serviceOrder) {
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

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Set<ServiceAction> getServiceActions() {
        return serviceActions;
    }

    public void setServiceActions(Set<ServiceAction> serviceActions) {
        this.serviceActions = serviceActions;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Set<ServicePart> getServiceParts() {
        return serviceParts;
    }

    public void setServiceParts(Set<ServicePart> serviceParts) {
        this.serviceParts = serviceParts;
    }

    public Set<ServiceNote> getServiceNotes() {
        return serviceNotes;
    }

    public void setServiceNotes(Set<ServiceNote> serviceNotes) {
        this.serviceNotes = serviceNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceOrder that = (ServiceOrder) o;

        if (serviceOrder != that.serviceOrder) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return serviceOrder;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "statusChangedBy=" + statusChangedBy +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                ", created=" + created +
                ", updated=" + updated +
                ", statusChanged=" + statusChanged +
                ", priceTotal=" + priceTotal +
                ", note='" + note + '\'' +
                ", serviceOrderStatusType=" + serviceOrderStatusType +
                ", serviceOrder=" + serviceOrder +
                ", serviceRequest=" + serviceRequest +
                '}';
    }
}
