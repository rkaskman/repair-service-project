package com.ttu.roman.model.service;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "service_request", schema = "public", catalog = "ri")
public class ServiceRequest {
    @Id
    @Column(name = "service_request", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceRequest;

    @Basic
    @Column(name = "customer_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer customerFk;

    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer createdBy;

    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp created;

    @Basic
    @Column(name = "service_desc_by_customer", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String serviceDescByCustomer;

    @Basic
    @Column(name = "service_desc_by_employee", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String serviceDescByEmployee;

    @ManyToOne
    @JoinColumn(name = "service_request_status_type_fk")
    private ServiceRequestStatusType serviceRequestStatusType;

    public int getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(int serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public Integer getCustomerFk() {
        return customerFk;
    }

    public void setCustomerFk(Integer customerFk) {
        this.customerFk = customerFk;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getServiceDescByCustomer() {
        return serviceDescByCustomer;
    }

    public void setServiceDescByCustomer(String serviceDescByCustomer) {
        this.serviceDescByCustomer = serviceDescByCustomer;
    }

    public String getServiceDescByEmployee() {
        return serviceDescByEmployee;
    }

    public void setServiceDescByEmployee(String serviceDescByEmployee) {
        this.serviceDescByEmployee = serviceDescByEmployee;
    }

    public ServiceRequestStatusType getServiceRequestStatusType() {
        return serviceRequestStatusType;
    }

    public void setServiceRequestStatusType(ServiceRequestStatusType serviceRequestStatusType) {
        this.serviceRequestStatusType = serviceRequestStatusType;
    }
}
