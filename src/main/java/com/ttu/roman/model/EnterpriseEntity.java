package com.ttu.roman.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "enterprise", schema = "public", catalog = "ri")
public class EnterpriseEntity {
    private int enterprise;
    private String name;
    private String fullName;
    private Integer createdBy;
    private Integer updatedBy;
    private Timestamp created;
    private Timestamp updated;

    @Id
    @Column(name = "enterprise", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(int enterprise) {
        this.enterprise = enterprise;
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
    @Column(name = "full_name", nullable = true, insertable = true, updatable = true, length = 2147483647, precision = 0)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "created_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
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
    @Column(name = "updated", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnterpriseEntity that = (EnterpriseEntity) o;

        if (enterprise != that.enterprise) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (fullName != null ? !fullName.equals(that.fullName) : that.fullName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        if (updatedBy != null ? !updatedBy.equals(that.updatedBy) : that.updatedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = enterprise;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }
}
