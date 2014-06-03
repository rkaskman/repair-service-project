package com.ttu.roman.model.device;

import javax.persistence.*;

@Entity
@Table(name = "device", schema = "public", catalog = "ri")
public class Device {
    @Id
    @Column(name = "device", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int device;

    @ManyToOne
    @JoinColumn(name="device_type_fk")
    private DeviceType deviceType;

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String name;

    @Basic
    @Column(name = "reg_no", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    private String regNo;

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String description;

    @Basic
    @Column(name = "model", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String model;

    @Basic
    @Column(name = "manufacturer", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    private String manufacturer;

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
