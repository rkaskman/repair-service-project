package com.ttu.roman.model.user;

import javax.persistence.*;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "employee", schema = "public", catalog = "ri")
public class Employee {
    private int employee;
    private Integer personFk;
    private Integer enterpriseFk;
    private Integer structUnitFk;
    private String active;


    @Id
    @Column(name = "employee", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "person_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }

    @Basic
    @Column(name = "enterprise_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getEnterpriseFk() {
        return enterpriseFk;
    }

    public void setEnterpriseFk(Integer enterpriseFk) {
        this.enterpriseFk = enterpriseFk;
    }

    @Basic
    @Column(name = "struct_unit_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getStructUnitFk() {
        return structUnitFk;
    }

    public void setStructUnitFk(Integer structUnitFk) {
        this.structUnitFk = structUnitFk;
    }

    @Basic
    @Column(name = "active", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee that = (Employee) o;

        if (employee != that.employee) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (enterpriseFk != null ? !enterpriseFk.equals(that.enterpriseFk) : that.enterpriseFk != null) return false;
        if (personFk != null ? !personFk.equals(that.personFk) : that.personFk != null) return false;
        if (structUnitFk != null ? !structUnitFk.equals(that.structUnitFk) : that.structUnitFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee;
        result = 31 * result + (personFk != null ? personFk.hashCode() : 0);
        result = 31 * result + (enterpriseFk != null ? enterpriseFk.hashCode() : 0);
        result = 31 * result + (structUnitFk != null ? structUnitFk.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }

}
