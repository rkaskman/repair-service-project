package com.ttu.roman.model.service;

import com.ttu.roman.model.device.Device;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "service_device", schema = "public", catalog = "ri")
@Cacheable(false)
public class ServiceDevice {

    @Id
    @Column(name = "service_device", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceDevice;

    @OneToMany(mappedBy = "serviceDevice")
    private Set<ServicePart> serviceParts;

    @ManyToOne
    @JoinColumn(name = "service_device_status_type_fk")
    private ServiceDeviceStatusType serviceDeviceStatusType;

    @ManyToOne
    @JoinColumn(name = "device_fk")
    private Device device;

    @ManyToOne
    @JoinColumn(name = "service_order_fk")
    private ServiceOrder serviceOrder;

    @Basic
    @Column(name = "to_store", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp toStore;

    @Basic
    @Column(name = "from_store", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp fromStore;

    @Basic
    @Column(name = "status_changed", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp statusChanged;

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public Device getDevice() {
        return device;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getServiceDevice() {
        return serviceDevice;
    }

    public void setServiceDevice(int serviceDevice) {
        this.serviceDevice = serviceDevice;
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

    public Timestamp getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(Timestamp statusChanged) {
        this.statusChanged = statusChanged;
    }

    public ServiceDeviceStatusType getServiceDeviceStatusType() {
        return serviceDeviceStatusType;
    }

    public void setServiceDeviceStatusType(ServiceDeviceStatusType serviceDeviceStatusType) {
        this.serviceDeviceStatusType = serviceDeviceStatusType;
    }

    public Set<ServicePart> getServiceParts() {
        return serviceParts;
    }

    public void setServiceParts(Set<ServicePart> serviceParts) {
        this.serviceParts = serviceParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceDevice that = (ServiceDevice) o;

        if (serviceDevice != that.serviceDevice) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return serviceDevice;
    }
}
