package com.ttu.roman.model;

import javax.persistence.*;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "device", schema = "public", catalog = "ri")
public class Device {
    private int device;
    private Integer deviceTypeFk;
    private String name;
    private String regNo;
    private String description;
    private String model;
    private String manufacturer;

    @Id
    @Column(name = "device", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    @Basic
    @Column(name = "device_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getDeviceTypeFk() {
        return deviceTypeFk;
    }

    public void setDeviceTypeFk(Integer deviceTypeFk) {
        this.deviceTypeFk = deviceTypeFk;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "reg_no", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "model", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "manufacturer", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device that = (Device) o;

        if (device != that.device) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (deviceTypeFk != null ? !deviceTypeFk.equals(that.deviceTypeFk) : that.deviceTypeFk != null) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (regNo != null ? !regNo.equals(that.regNo) : that.regNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = device;
        result = 31 * result + (deviceTypeFk != null ? deviceTypeFk.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (regNo != null ? regNo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }
}
