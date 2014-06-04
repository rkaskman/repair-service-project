package com.ttu.roman.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
public class PersonCustomer extends AbstractCustomer {

    private Person person;

    @OneToOne
    @JoinColumn(name = "subject_fk", referencedColumnName = "person")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
