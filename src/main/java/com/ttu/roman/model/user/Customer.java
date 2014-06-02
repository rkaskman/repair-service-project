package com.ttu.roman.model.user;

import javax.persistence.*;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "customer", schema = "public", catalog = "ri")
public class Customer {
    private int customer;
    private Integer subjectFk;
    private Integer subjectTypeFk;

    @Id
    @Column(name = "customer", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @Basic
    @Column(name = "subject_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    @Basic
    @Column(name = "subject_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer that = (Customer) o;

        if (customer != that.customer) return false;
        if (subjectFk != null ? !subjectFk.equals(that.subjectFk) : that.subjectFk != null) return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(that.subjectTypeFk) : that.subjectTypeFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customer;
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        return result;
    }
}
