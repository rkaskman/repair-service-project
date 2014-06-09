package com.ttu.roman.model.device;

import com.ttu.roman.model.service.ServiceOrder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "device", schema = "public", catalog = "ri")
@Cacheable(false)
public class Device {

    @Id
    @SequenceGenerator(name="device_id", initialValue=4, allocationSize=1, schema = "public", catalog = "ri", sequenceName = "device_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "device_id")
    @Column(name = "device", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer device;

    @ManyToOne
    @JoinColumn(name="device_type_fk")
    private DeviceType deviceType;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="service_device",
            joinColumns={@JoinColumn(name="device_fk", referencedColumnName="device")},
            inverseJoinColumns={@JoinColumn(name="service_order_fk", referencedColumnName="service_order")})
    private Set<ServiceOrder> serviceOrders;

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

    public Integer getDevice() {
        return device;
    }

    public void setDevice(Integer device) {
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

    public Set<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(Set<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device1 = (Device) o;

        if (device != device1.device) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return device;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceType=" + deviceType +
                ", device=" + device +
                ", name='" + name + '\'' +
                ", regNo='" + regNo + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
