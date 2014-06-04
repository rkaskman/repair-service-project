package com.ttu.roman.model.user;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class EnterpriseCustomer extends AbstractCustomer {

    private Enterprise enterprise;

    @OneToOne
    @JoinColumn(name = "subject_fk", referencedColumnName = "enterprise")
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
}
