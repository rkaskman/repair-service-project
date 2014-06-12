package com.ttu.roman.model.service;

import com.ttu.roman.model.user.AbstractCustomer;
import com.ttu.roman.model.user.Employee;
import com.ttu.roman.model.user.Person;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "service_note", schema = "public", catalog = "ri")
public class ServiceNote {
    @Id
    @SequenceGenerator(name="service_note_id", initialValue=200, allocationSize=1, schema = "public", catalog = "ri", sequenceName = "service_note_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "service_note_id")
    @Column(name = "service_note", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceNote;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private AbstractCustomer customer;

    @ManyToOne
    @JoinColumn(name = "employee_fk")
    private Employee employee;

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

    public Integer getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(Integer serviceNote) {
        this.serviceNote = serviceNote;
    }

    public AbstractCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(AbstractCustomer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNoteAuthorName() {
        if(customer != null) {
            return customer.retrieveCustomerName();
        }
        if(employee != null) {
            Person person = employee.getPerson();
            return person.getFirstName() + " " + person.getLastName();
        }

        return "";
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

                ", serviceOrder=" + serviceOrder +
                ", noteAuthorType=" + noteAuthorType +
                ", created=" + created +
                ", note='" + note + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceNote that = (ServiceNote) o;

        if (serviceNote != that.serviceNote) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return serviceNote;
    }
}
