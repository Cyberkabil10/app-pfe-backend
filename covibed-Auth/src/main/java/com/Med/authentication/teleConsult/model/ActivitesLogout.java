package com.Med.authentication.teleConsult.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "ActivitesLogout")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@pkActivitesLogoutID")

public class ActivitesLogout  implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkActivitesLogoutID")
    private long pkActivitesLogoutID;

    @Column(name = "username")
    private String username;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private Date date;
     @Transient
    private String DateTo;
     @Transient
    private String DateFrom;

    public long getPkActivitesLogoutID() {
        return pkActivitesLogoutID;
    }

    public void setPkActivitesLogoutID(long pkActivitesLogoutID) {
        this.pkActivitesLogoutID = pkActivitesLogoutID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateTo() {
        return DateTo;
    }

    public void setDateTo(String dateTo) {
        DateTo = dateTo;
    }

    public String getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(String dateFrom) {
        DateFrom = dateFrom;
    }




}
