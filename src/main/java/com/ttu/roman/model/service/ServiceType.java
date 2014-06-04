package com.ttu.roman.model.service;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "service_type", schema = "public", catalog = "ri")
public class ServiceType {
    @Id
    @Column(name = "service_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceType;

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
    private List<ServiceAction> serviceActions;

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
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

    public List<ServiceAction> getServiceActions() {
        return serviceActions;
    }

    public void setServiceActions(List<ServiceAction> serviceActions) {
        this.serviceActions = serviceActions;
    }

    public ServiceUnitType getServiceUnitType() {
        return serviceUnitType;
    }

    public void setServiceUnitType(ServiceUnitType serviceUnitType) {
        this.serviceUnitType = serviceUnitType;
    }

}
