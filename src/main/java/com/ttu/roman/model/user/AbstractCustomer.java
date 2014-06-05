package com.ttu.roman.model.user;

import com.ttu.roman.model.service.ServiceRequest;

import javax.persistence.*;
import java.util.List;


@Entity
@Inheritance
@DiscriminatorColumn(name="subject_type_fk", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "customer", schema = "public", catalog = "ri")
public abstract class AbstractCustomer {
    private int customer;
private List<ServiceRequest> serviceRequests;

    @Id
    @Column(name = "customer", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "customer")
    public List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    public void setServiceRequests(List<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }
}
