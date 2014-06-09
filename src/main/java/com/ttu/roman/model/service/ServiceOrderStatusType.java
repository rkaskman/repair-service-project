package com.ttu.roman.model.service;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "so_status_type", schema = "public", catalog = "ri")
public class ServiceOrderStatusType {
    @Id
    @Column(name = "so_status_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int soStatusType;
    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String typeName;

    @OneToMany(mappedBy = "serviceOrderStatusType")
    private Set<ServiceOrder> serviceOrders;

    public int getSoStatusType() {
        return soStatusType;
    }

    public void setSoStatusType(int soStatusType) {
        this.soStatusType = soStatusType;
    }

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

        ServiceOrderStatusType that = (ServiceOrderStatusType) o;

        if (soStatusType != that.soStatusType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return soStatusType;
    }

    @Override
    public String toString() {
        return "ServiceOrderStatusType{" +
                "soStatusType=" + soStatusType +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
