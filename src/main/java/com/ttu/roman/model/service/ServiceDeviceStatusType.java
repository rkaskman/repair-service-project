package com.ttu.roman.model.service;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service_device_status_type", schema = "public", catalog = "ri")
public class ServiceDeviceStatusType {
    @Id
    @Column(name = "service_device_status_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceDeviceStatusType;

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String typeName;

    @OneToMany(mappedBy = "serviceDeviceStatusType")
    private Set<ServiceDevice> serviceDevices;

    public int getServiceDeviceStatusType() {
        return serviceDeviceStatusType;
    }

    public void setServiceDeviceStatusType(int serviceDeviceStatusType) {
        this.serviceDeviceStatusType = serviceDeviceStatusType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setServiceDevices(Set<ServiceDevice> serviceDevices) {
        this.serviceDevices = serviceDevices;
    }

    public Set<ServiceDevice> getServiceDevices() {
        return serviceDevices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceDeviceStatusType that = (ServiceDeviceStatusType) o;

        if (serviceDeviceStatusType != that.serviceDeviceStatusType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return serviceDeviceStatusType;
    }
}
