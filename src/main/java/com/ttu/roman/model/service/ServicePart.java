package com.ttu.roman.model.service;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_part", schema = "public", catalog = "ri")
public class ServicePart {
    private int servicePart;
    private Integer serviceOrderFk;
    private Integer serviceDeviceFk;
    private String partName;
    private String serialNo;
    private Integer partCount;
    private BigInteger partPrice;
    private Timestamp created;
    private Integer createdBy;

    @Id
    @Column(name = "service_part", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServicePart() {
        return servicePart;
    }

    public void setServicePart(int servicePart) {
        this.servicePart = servicePart;
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
    @Column(name = "service_device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceDeviceFk() {
        return serviceDeviceFk;
    }

    public void setServiceDeviceFk(Integer serviceDeviceFk) {
        this.serviceDeviceFk = serviceDeviceFk;
    }

    @Basic
    @Column(name = "part_name", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Basic
    @Column(name = "serial_no", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Basic
    @Column(name = "part_count", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getPartCount() {
        return partCount;
    }

    public void setPartCount(Integer partCount) {
        this.partCount = partCount;
    }

    @Basic
    @Column(name = "part_price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    public BigInteger getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(BigInteger partPrice) {
        this.partPrice = partPrice;
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

        ServicePart that = (ServicePart) o;

        if (servicePart != that.servicePart) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (partCount != null ? !partCount.equals(that.partCount) : that.partCount != null) return false;
        if (partName != null ? !partName.equals(that.partName) : that.partName != null) return false;
        if (partPrice != null ? !partPrice.equals(that.partPrice) : that.partPrice != null) return false;
        if (serialNo != null ? !serialNo.equals(that.serialNo) : that.serialNo != null) return false;
        if (serviceDeviceFk != null ? !serviceDeviceFk.equals(that.serviceDeviceFk) : that.serviceDeviceFk != null)
            return false;
        if (serviceOrderFk != null ? !serviceOrderFk.equals(that.serviceOrderFk) : that.serviceOrderFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = servicePart;
        result = 31 * result + (serviceOrderFk != null ? serviceOrderFk.hashCode() : 0);
        result = 31 * result + (serviceDeviceFk != null ? serviceDeviceFk.hashCode() : 0);
        result = 31 * result + (partName != null ? partName.hashCode() : 0);
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        result = 31 * result + (partCount != null ? partCount.hashCode() : 0);
        result = 31 * result + (partPrice != null ? partPrice.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }
}
