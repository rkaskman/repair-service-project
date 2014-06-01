package com.ttu.roman.model.service;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_device", schema = "public", catalog = "ri")
public class ServiceDevice {
    private int serviceDevice;
    private Integer serviceDeviceStatusTypeFk;
    private Integer deviceFk;
    private Integer serviceOrderFk;
    private Timestamp toStore;
    private Timestamp fromStore;
    private String serviceDescription;
    private Timestamp statusChanged;
    private BigInteger storeStatus;

    @Id
    @Column(name = "service_device", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServiceDevice() {
        return serviceDevice;
    }

    public void setServiceDevice(int serviceDevice) {
        this.serviceDevice = serviceDevice;
    }

    @Basic
    @Column(name = "service_device_status_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceDeviceStatusTypeFk() {
        return serviceDeviceStatusTypeFk;
    }

    public void setServiceDeviceStatusTypeFk(Integer serviceDeviceStatusTypeFk) {
        this.serviceDeviceStatusTypeFk = serviceDeviceStatusTypeFk;
    }

    @Basic
    @Column(name = "device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getDeviceFk() {
        return deviceFk;
    }

    public void setDeviceFk(Integer deviceFk) {
        this.deviceFk = deviceFk;
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
    @Column(name = "to_store", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getToStore() {
        return toStore;
    }

    public void setToStore(Timestamp toStore) {
        this.toStore = toStore;
    }

    @Basic
    @Column(name = "from_store", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getFromStore() {
        return fromStore;
    }

    public void setFromStore(Timestamp fromStore) {
        this.fromStore = fromStore;
    }

    @Basic
    @Column(name = "service_description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
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
    @Column(name = "store_status", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public BigInteger getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(BigInteger storeStatus) {
        this.storeStatus = storeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceDevice that = (ServiceDevice) o;

        if (serviceDevice != that.serviceDevice) return false;
        if (deviceFk != null ? !deviceFk.equals(that.deviceFk) : that.deviceFk != null) return false;
        if (fromStore != null ? !fromStore.equals(that.fromStore) : that.fromStore != null) return false;
        if (serviceDescription != null ? !serviceDescription.equals(that.serviceDescription) : that.serviceDescription != null)
            return false;
        if (serviceDeviceStatusTypeFk != null ? !serviceDeviceStatusTypeFk.equals(that.serviceDeviceStatusTypeFk) : that.serviceDeviceStatusTypeFk != null)
            return false;
        if (serviceOrderFk != null ? !serviceOrderFk.equals(that.serviceOrderFk) : that.serviceOrderFk != null)
            return false;
        if (statusChanged != null ? !statusChanged.equals(that.statusChanged) : that.statusChanged != null)
            return false;
        if (storeStatus != null ? !storeStatus.equals(that.storeStatus) : that.storeStatus != null) return false;
        if (toStore != null ? !toStore.equals(that.toStore) : that.toStore != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceDevice;
        result = 31 * result + (serviceDeviceStatusTypeFk != null ? serviceDeviceStatusTypeFk.hashCode() : 0);
        result = 31 * result + (deviceFk != null ? deviceFk.hashCode() : 0);
        result = 31 * result + (serviceOrderFk != null ? serviceOrderFk.hashCode() : 0);
        result = 31 * result + (toStore != null ? toStore.hashCode() : 0);
        result = 31 * result + (fromStore != null ? fromStore.hashCode() : 0);
        result = 31 * result + (serviceDescription != null ? serviceDescription.hashCode() : 0);
        result = 31 * result + (statusChanged != null ? statusChanged.hashCode() : 0);
        result = 31 * result + (storeStatus != null ? storeStatus.hashCode() : 0);
        return result;
    }
}
