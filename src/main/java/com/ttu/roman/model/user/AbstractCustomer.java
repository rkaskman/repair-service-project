package com.ttu.roman.model.user;

import javax.persistence.*;


@Entity
@Inheritance
@DiscriminatorColumn(name="subject_type_fk", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "customer", schema = "public", catalog = "ri")
public abstract class AbstractCustomer {
    private int customer;

    @Id
    @Column(name = "customer", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
}
