package com.ttu.roman.model.user;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("3")
public class EmployeeUserAccount extends UserAccount {

    private Employee employee;

    @OneToOne
    @JoinColumn(name = "subject_fk", referencedColumnName = "employee")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
