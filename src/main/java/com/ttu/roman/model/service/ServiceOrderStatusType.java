package com.ttu.roman.model.service;

import javax.persistence.*;
import java.util.List;

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
    private List<ServiceOrder> serviceOrders;

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

}
