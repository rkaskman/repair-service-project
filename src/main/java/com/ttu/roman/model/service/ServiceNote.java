package com.ttu.roman.model.service;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "service_note", schema = "public", catalog = "ri")
public class ServiceNote {
    @Id
    @Column(name = "service_note", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int serviceNote;

    @Basic
    @Column(name = "customer_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer customerFk;

    @Basic
    @Column(name = "employee_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer employeeFk;

    @ManyToOne
    @JoinColumn(name = "service_order_fk")
    private ServiceOrder serviceOrder;

    @Basic
    @Column(name = "note_author_type", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer noteAuthorType;

    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp created;

    @Basic
    @Column(name = "note", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String note;

    public int getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(int serviceNote) {
        this.serviceNote = serviceNote;
    }

    public Integer getCustomerFk() {
        return customerFk;
    }

    public void setCustomerFk(Integer customerFk) {
        this.customerFk = customerFk;
    }

    public Integer getEmployeeFk() {
        return employeeFk;
    }

    public void setEmployeeFk(Integer employeeFk) {
        this.employeeFk = employeeFk;
    }

    public Integer getNoteAuthorType() {
        return noteAuthorType;
    }

    public void setNoteAuthorType(Integer noteAuthorType) {
        this.noteAuthorType = noteAuthorType;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ServiceOrder getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    @Override
    public String toString() {
        return "ServiceNote{" +
                "serviceNote=" + serviceNote +
                ", customerFk=" + customerFk +
                ", employeeFk=" + employeeFk +
                ", serviceOrder=" + serviceOrder +
                ", noteAuthorType=" + noteAuthorType +
                ", created=" + created +
                ", note='" + note + '\'' +
                '}';
    }
}
