package com.ttu.roman.model.service;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "service_device", schema = "public", catalog = "ri")
public class ServiceDevice {
    @Id
    @Column(name = "service_device", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceDevice;

    @ManyToOne
    @JoinColumn(name = "service_device_status_type_fk")
    private ServiceDeviceStatusType serviceDeviceStatusType;

    @Basic
    @Column(name = "device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer deviceFk;

    @Basic
    @Column(name = "service_order_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceOrderFk;

    @Basic
    @Column(name = "to_store", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp toStore;

    @Basic
    @Column(name = "from_store", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp fromStore;

    @Basic
    @Column(name = "service_description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String serviceDescription;

    @Basic
    @Column(name = "status_changed", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp statusChanged;

    @Basic
    @Column(name = "store_status", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    private BigInteger storeStatus;

    public int getServiceDevice() {
        return serviceDevice;
    }

    public void setServiceDevice(int serviceDevice) {
        this.serviceDevice = serviceDevice;
    }


    public Integer getDeviceFk() {
        return deviceFk;
    }

    public void setDeviceFk(Integer deviceFk) {
        this.deviceFk = deviceFk;
    }

    public Integer getServiceOrderFk() {
        return serviceOrderFk;
    }

    public void setServiceOrderFk(Integer serviceOrderFk) {
        this.serviceOrderFk = serviceOrderFk;
    }

    public Timestamp getToStore() {
        return toStore;
    }

    public void setToStore(Timestamp toStore) {
        this.toStore = toStore;
    }

    public Timestamp getFromStore() {
        return fromStore;
    }

    public void setFromStore(Timestamp fromStore) {
        this.fromStore = fromStore;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Timestamp getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(Timestamp statusChanged) {
        this.statusChanged = statusChanged;
    }

    public BigInteger getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(BigInteger storeStatus) {
        this.storeStatus = storeStatus;
    }

    public ServiceDeviceStatusType getServiceDeviceStatusType() {
        return serviceDeviceStatusType;
    }

    public void setServiceDeviceStatusType(ServiceDeviceStatusType serviceDeviceStatusType) {
        this.serviceDeviceStatusType = serviceDeviceStatusType;
    }
}
