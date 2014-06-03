package com.ttu.roman.model.device;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device_type", schema = "public", catalog = "ri")
public class DeviceType {
    @Id
    @Column(name = "device_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int deviceType;

    @Basic
    @Column(name = "super_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer superTypeFk;

    @Basic
    @Column(name = "level", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    private Integer level;

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    private String typeName;

    @OneToMany(mappedBy = "deviceType")
    private List<Device> devices;

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getSuperTypeFk() {
        return superTypeFk;
    }

    public void setSuperTypeFk(Integer superTypeFk) {
        this.superTypeFk = superTypeFk;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
