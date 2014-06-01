package com.ttu.roman.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_order", schema = "public", catalog = "ri")
public class ServiceOrderEntity {
    private int serviceOrder;
    private Integer soStatusTypeFk;
    private Integer createdBy;
    private Integer serviceRequestFk;
    private Integer updatedBy;
    private Timestamp created;
    private Timestamp updated;
    private Timestamp statusChanged;
    private Integer statusChangedBy;
    private BigInteger priceTotal;
    private String note;

    @Id
    @Column(name = "service_order", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(int serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Basic
    @Column(name = "so_status_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getSoStatusTypeFk() {
        return soStatusTypeFk;
    }

    public void setSoStatusTypeFk(Integer soStatusTypeFk) {
        this.soStatusTypeFk = soStatusTypeFk;
    }

    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "service_request_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceRequestFk() {
        return serviceRequestFk;
    }

    public void setServiceRequestFk(Integer serviceRequestFk) {
        this.serviceRequestFk = serviceRequestFk;
    }

    @Basic
    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "updated", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Basic
    @Column(name = "status_changed", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(Timestamp statusChanged) {
        this.statusChanged = statusChanged;
    }

    @Basic
    @Column(name = "status_changed_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getStatusChangedBy() {
        return statusChangedBy;
    }

    public void setStatusChangedBy(Integer statusChangedBy) {
        this.statusChangedBy = statusChangedBy;
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
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceOrderEntity that = (ServiceOrderEntity) o;

        if (serviceOrder != that.serviceOrder) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (priceTotal != null ? !priceTotal.equals(that.priceTotal) : that.priceTotal != null) return false;
        if (serviceRequestFk != null ? !serviceRequestFk.equals(that.serviceRequestFk) : that.serviceRequestFk != null)
            return false;
        if (soStatusTypeFk != null ? !soStatusTypeFk.equals(that.soStatusTypeFk) : that.soStatusTypeFk != null)
            return false;
        if (statusChanged != null ? !statusChanged.equals(that.statusChanged) : that.statusChanged != null)
            return false;
        if (statusChangedBy != null ? !statusChangedBy.equals(that.statusChangedBy) : that.statusChangedBy != null)
            return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceOrder;
        result = 31 * result + (soStatusTypeFk != null ? soStatusTypeFk.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (serviceRequestFk != null ? serviceRequestFk.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (statusChanged != null ? statusChanged.hashCode() : 0);
        result = 31 * result + (statusChangedBy != null ? statusChangedBy.hashCode() : 0);
        result = 31 * result + (priceTotal != null ? priceTotal.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
