package com.ttu.roman.model.user;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Roman on 1.06.14.
 */
@Entity
@Table(name = "user_account", schema = "public", catalog = "ri")
public class UserAccount {
    private int userAccount;
    private Integer subjectTypeFk;
    private Integer subjectFk;
    private String username;
    private String passw;
    private Integer status;
    private Date validFrom;
    private Date validTo;
    private Integer createdBy;
    private Timestamp created;
    private String passwordNeverExpires;

    @Id
    @Column(name = "user_account", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(int userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "subject_type_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    @Basic
    @Column(name = "subject_fk", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    @Basic
    @Column(name = "username", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "passw", nullable = true, insertable = true, updatable = true, length = 300, precision = 0)
    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "valid_from", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Basic
    @Column(name = "valid_to", nullable = true, insertable = true, updatable = true, length = 13, precision = 0)
    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
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
    @Column(name = "created", nullable = true, insertable = true, updatable = true, length = 29, precision = 6)
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "password_never_expires", nullable = true, insertable = true, updatable = true, length = 1, precision = 0)
    public String getPasswordNeverExpires() {
        return passwordNeverExpires;
    }

    public void setPasswordNeverExpires(String passwordNeverExpires) {
        this.passwordNeverExpires = passwordNeverExpires;
    }

}
