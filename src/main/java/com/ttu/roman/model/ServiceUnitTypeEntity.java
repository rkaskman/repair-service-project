package com.ttu.roman.model;

import javax.persistence.*;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_unit_type", schema = "public", catalog = "ri")
public class ServiceUnitTypeEntity {
    private int serviceUnitType;
    private String typeName;

    @Id
    @Column(name = "service_unit_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServiceUnitType() {
        return serviceUnitType;
    }

    public void setServiceUnitType(int serviceUnitType) {
        this.serviceUnitType = serviceUnitType;
    }

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceUnitTypeEntity that = (ServiceUnitTypeEntity) o;

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
