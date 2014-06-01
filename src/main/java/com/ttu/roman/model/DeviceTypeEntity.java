package com.ttu.roman.model;

import javax.persistence.*;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "device_type", schema = "public", catalog = "ri")
public class DeviceTypeEntity {
    private int deviceType;
    private Integer superTypeFk;
    private Integer level;
    private String typeName;

    @Id
    @Column(name = "device_type", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    @Basic
    @Column(name = "super_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getSuperTypeFk() {
        return superTypeFk;
    }

    public void setSuperTypeFk(Integer superTypeFk) {
        this.superTypeFk = superTypeFk;
    }

    @Basic
    @Column(name = "level", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "type_name", nullable = true, insertable = true, updatable = true, length = 200, precision = 0)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceTypeEntity that = (DeviceTypeEntity) o;

        if (deviceType != that.deviceType) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (superTypeFk != null ? !superTypeFk.equals(that.superTypeFk) : that.superTypeFk != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceType;
        result = 31 * result + (superTypeFk != null ? superTypeFk.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
