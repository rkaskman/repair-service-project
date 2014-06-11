package com.ttu.roman.model.service;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "service_type", schema = "public", catalog = "ri")
public class ServiceType {
    @Id
    @Column(name = "service_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceType;

    @ManyToOne
    @JoinColumn(name = "service_unit_type_fk")
    private ServiceUnitType serviceUnitType;

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String typeName;

    @Basic
    @Column(name = "service_price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger servicePrice;

    @OneToMany(mappedBy = "serviceType")
    private Set<ServiceAction> serviceActions;

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigInteger getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigInteger servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Set<ServiceAction> getServiceActions() {
        return serviceActions;
    }

    public void setServiceActions(Set<ServiceAction> serviceActions) {
        this.serviceActions = serviceActions;
    }

    public ServiceUnitType getServiceUnitType() {
        return serviceUnitType;
    }

    public void setServiceUnitType(ServiceUnitType serviceUnitType) {
        this.serviceUnitType = serviceUnitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceType that = (ServiceType) o;

        if (serviceType != that.serviceType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return serviceType;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "serviceType=" + serviceType +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
