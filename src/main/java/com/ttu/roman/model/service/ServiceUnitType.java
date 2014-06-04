package com.ttu.roman.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_unit_type", schema = "public", catalog = "ri")
public class ServiceUnitType {
    @Id
    @Column(name = "service_unit_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceUnitType;

    @OneToMany(mappedBy = "serviceUnitType")
    private List<ServiceType> serviceTypes;

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String typeName;

    public int getServiceUnitType() {
        return serviceUnitType;
    }

    public void setServiceUnitType(int serviceUnitType) {
        this.serviceUnitType = serviceUnitType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<ServiceType> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<ServiceType> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceUnitType that = (ServiceUnitType) o;

        if (serviceUnitType != that.serviceUnitType) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceUnitType;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
