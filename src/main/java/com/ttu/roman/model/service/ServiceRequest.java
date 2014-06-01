package com.ttu.roman.model.service;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_request", schema = "public", catalog = "ri")
public class ServiceRequest {
    private int serviceRequest;
    private Integer customerFk;
    private Integer createdBy;
    private Timestamp created;
    private String serviceDescByCustomer;
    private String serviceDescByEmployee;
    private Integer serviceRequestStatusTypeFk;

    @Id
    @Column(name = "service_request", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(int serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    @Basic
    @Column(name = "customer_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getCustomerFk() {
        return customerFk;
    }

    public void setCustomerFk(Integer customerFk) {
        this.customerFk = customerFk;
    }

    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "service_desc_by_customer", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getServiceDescByCustomer() {
        return serviceDescByCustomer;
    }

    public void setServiceDescByCustomer(String serviceDescByCustomer) {
        this.serviceDescByCustomer = serviceDescByCustomer;
    }

    @Basic
    @Column(name = "service_desc_by_employee", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getServiceDescByEmployee() {
        return serviceDescByEmployee;
    }

    public void setServiceDescByEmployee(String serviceDescByEmployee) {
        this.serviceDescByEmployee = serviceDescByEmployee;
    }

    @Basic
    @Column(name = "service_request_status_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceRequestStatusTypeFk() {
        return serviceRequestStatusTypeFk;
    }

    public void setServiceRequestStatusTypeFk(Integer serviceRequestStatusTypeFk) {
        this.serviceRequestStatusTypeFk = serviceRequestStatusTypeFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceRequest that = (ServiceRequest) o;

        if (serviceRequest != that.serviceRequest) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (customerFk != null ? !customerFk.equals(that.customerFk) : that.customerFk != null) return false;
        if (serviceDescByCustomer != null ? !serviceDescByCustomer.equals(that.serviceDescByCustomer) : that.serviceDescByCustomer != null)
            return false;
        if (serviceDescByEmployee != null ? !serviceDescByEmployee.equals(that.serviceDescByEmployee) : that.serviceDescByEmployee != null)
            return false;
        if (serviceRequestStatusTypeFk != null ? !serviceRequestStatusTypeFk.equals(that.serviceRequestStatusTypeFk) : that.serviceRequestStatusTypeFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceRequest;
        result = 31 * result + (customerFk != null ? customerFk.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (serviceDescByCustomer != null ? serviceDescByCustomer.hashCode() : 0);
        result = 31 * result + (serviceDescByEmployee != null ? serviceDescByEmployee.hashCode() : 0);
        result = 31 * result + (serviceRequestStatusTypeFk != null ? serviceRequestStatusTypeFk.hashCode() : 0);
        return result;
    }
}
