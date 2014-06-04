package com.ttu.roman.model.service;

import com.ttu.roman.model.invoice.InvoiceRow;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "service_part", schema = "public", catalog = "ri")
public class ServicePart {
    @Id
    @Column(name = "service_part", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int servicePart;

    @OneToMany(mappedBy = "servicePart")
    private List<InvoiceRow> invoiceRows;

    @Basic
    @Column(name = "service_order_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer serviceOrderFk;

    @ManyToOne
    @JoinColumn(name="service_device_fk")
    private ServiceDevice serviceDevice;

    @Basic
    @Column(name = "part_name", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String partName;
    @Basic
    @Column(name = "serial_no", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String serialNo;
    @Basic
    @Column(name = "part_count", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer partCount;
    @Basic
    @Column(name = "part_price", nullable = true, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger partPrice;
    @Basic
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    private Timestamp created;
    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer createdBy;

    public int getServicePart() {
        return servicePart;
    }

    public void setServicePart(int servicePart) {
        this.servicePart = servicePart;
    }

    public Integer getServiceOrderFk() {
        return serviceOrderFk;
    }

    public void setServiceOrderFk(Integer serviceOrderFk) {
        this.serviceOrderFk = serviceOrderFk;
    }


    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Integer getPartCount() {
        return partCount;
    }

    public void setPartCount(Integer partCount) {
        this.partCount = partCount;
    }

    public BigInteger getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(BigInteger partPrice) {
        this.partPrice = partPrice;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }

    public ServiceDevice getServiceDevice() {
        return serviceDevice;
    }

    public void setServiceDevice(ServiceDevice serviceDevice) {
        this.serviceDevice = serviceDevice;
    }
}
