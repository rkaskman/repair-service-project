package com.ttu.roman.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("4")
public class CustomerUserAccount extends UserAccount {

    AbstractCustomer abstractCustomer;

    @OneToOne
    @JoinColumn(name = "subject_fk", referencedColumnName = "customer")
    public AbstractCustomer getAbstractCustomer() {
        return abstractCustomer;
    }

    public void setAbstractCustomer(AbstractCustomer abstractCustomer) {
        this.abstractCustomer = abstractCustomer;
    }
}
