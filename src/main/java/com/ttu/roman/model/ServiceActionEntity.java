package com.ttu.roman.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_action", schema = "public", catalog = "ri")
public class ServiceActionEntity {
    private int serviceAction;
    private Integer serviceActionStatusTypeFk;
    private Integer serviceTypeFk;
    private Integer serviceDeviceFk;
    private Integer serviceOrderFk;
    private BigInteger serviceAmount;
    private BigInteger price;
    private Timestamp priceUpdated;
    private String actionDescription;
    private Timestamp created;
    private Integer createdBy;

    @Id
    @Column(name = "service_action", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServiceAction() {
        return serviceAction;
    }

    public void setServiceAction(int serviceAction) {
        this.serviceAction = serviceAction;
    }

    @Basic
    @Column(name = "service_action_status_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceActionStatusTypeFk() {
        return serviceActionStatusTypeFk;
    }

    public void setServiceActionStatusTypeFk(Integer serviceActionStatusTypeFk) {
        this.serviceActionStatusTypeFk = serviceActionStatusTypeFk;
    }

    @Basic
    @Column(name = "service_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceTypeFk() {
        return serviceTypeFk;
    }

    public void setServiceTypeFk(Integer serviceTypeFk) {
        this.serviceTypeFk = serviceTypeFk;
    }

    @Basic
    @Column(name = "service_device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceDeviceFk() {
        return serviceDeviceFk;
    }

    public void setServiceDeviceFk(Integer serviceDeviceFk) {
        this.serviceDeviceFk = serviceDeviceFk;
    }

    @Basic
    @Column(name = "service_order_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceOrderFk() {
        return serviceOrderFk;
    }

    public void setServiceOrderFk(Integer serviceOrderFk) {
        this.serviceOrderFk = serviceOrderFk;
    }

    @Basic
    @Column(name = "service_amount", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    public BigInteger getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigInteger serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Basic
    @Column(name = "price_updated", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getPriceUpdated() {
        return priceUpdated;
    }

    public void setPriceUpdated(Timestamp priceUpdated) {
        this.priceUpdated = priceUpdated;
    }

    @Basic
    @Column(name = "action_description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
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
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceActionEntity that = (ServiceActionEntity) o;

        if (serviceAction != that.serviceAction) return false;
        if (actionDescription != null ? !actionDescription.equals(that.actionDescription) : that.actionDescription != null)
            return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (priceUpdated != null ? !priceUpdated.equals(that.priceUpdated) : that.priceUpdated != null) return false;
        if (serviceActionStatusTypeFk != null ? !serviceActionStatusTypeFk.equals(that.serviceActionStatusTypeFk) : that.serviceActionStatusTypeFk != null)
            return false;
        if (serviceAmount != null ? !serviceAmount.equals(that.serviceAmount) : that.serviceAmount != null)
            return false;
        if (serviceDeviceFk != null ? !serviceDeviceFk.equals(that.serviceDeviceFk) : that.serviceDeviceFk != null)
            return false;
        if (serviceOrderFk != null ? !serviceOrderFk.equals(that.serviceOrderFk) : that.serviceOrderFk != null)
            return false;
        if (serviceTypeFk != null ? !serviceTypeFk.equals(that.serviceTypeFk) : that.serviceTypeFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceAction;
        result = 31 * result + (serviceActionStatusTypeFk != null ? serviceActionStatusTypeFk.hashCode() : 0);
        result = 31 * result + (serviceTypeFk != null ? serviceTypeFk.hashCode() : 0);
        result = 31 * result + (serviceDeviceFk != null ? serviceDeviceFk.hashCode() : 0);
        result = 31 * result + (serviceOrderFk != null ? serviceOrderFk.hashCode() : 0);
        result = 31 * result + (serviceAmount != null ? serviceAmount.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (priceUpdated != null ? priceUpdated.hashCode() : 0);
        result = 31 * result + (actionDescription != null ? actionDescription.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }
}
