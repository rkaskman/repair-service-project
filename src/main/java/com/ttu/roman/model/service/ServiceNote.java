package com.ttu.roman.model.service;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "service_note", schema = "public", catalog = "ri")
public class ServiceNote {
    private int serviceNote;
    private Integer customerFk;
    private Integer employeeFk;
    private Integer serviceOrderFk;
    private Integer serviceDeviceFk;
    private Integer noteAuthorType;
    private Timestamp created;
    private String note;

    @Id
    @Column(name = "service_note", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(int serviceNote) {
        this.serviceNote = serviceNote;
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
    @Column(name = "employee_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getEmployeeFk() {
        return employeeFk;
    }

    public void setEmployeeFk(Integer employeeFk) {
        this.employeeFk = employeeFk;
    }

    @Basic
    @Column(name = "service_order_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceOrderFk() {
        return serviceOrderFk;
    }

    public void setServiceOrderFk(Integer serviceOrderFk) {
        this.serviceOrderFk = serviceOrderFk;
    }

    @Basic
    @Column(name = "service_device_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getServiceDeviceFk() {
        return serviceDeviceFk;
    }

    public void setServiceDeviceFk(Integer serviceDeviceFk) {
        this.serviceDeviceFk = serviceDeviceFk;
    }

    @Basic
    @Column(name = "note_author_type", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getNoteAuthorType() {
        return noteAuthorType;
    }

    public void setNoteAuthorType(Integer noteAuthorType) {
        this.noteAuthorType = noteAuthorType;
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
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceNote that = (ServiceNote) o;

        if (serviceNote != that.serviceNote) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (customerFk != null ? !customerFk.equals(that.customerFk) : that.customerFk != null) return false;
        if (employeeFk != null ? !employeeFk.equals(that.employeeFk) : that.employeeFk != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (noteAuthorType != null ? !noteAuthorType.equals(that.noteAuthorType) : that.noteAuthorType != null)
            return false;
        if (serviceDeviceFk != null ? !serviceDeviceFk.equals(that.serviceDeviceFk) : that.serviceDeviceFk != null)
            return false;
        if (serviceOrderFk != null ? !serviceOrderFk.equals(that.serviceOrderFk) : that.serviceOrderFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceNote;
        result = 31 * result + (customerFk != null ? customerFk.hashCode() : 0);
        result = 31 * result + (employeeFk != null ? employeeFk.hashCode() : 0);
        result = 31 * result + (serviceOrderFk != null ? serviceOrderFk.hashCode() : 0);
        result = 31 * result + (serviceDeviceFk != null ? serviceDeviceFk.hashCode() : 0);
        result = 31 * result + (noteAuthorType != null ? noteAuthorType.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
