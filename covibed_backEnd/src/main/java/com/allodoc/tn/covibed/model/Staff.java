package com.allodoc.tn.covibed.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Staff")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@staffID")
public class Staff implements Serializable {
    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staffID")
    private long staffID;
    @Column(name = "fonction")
    private String fonction;
    @Column(name = "notifID")
    private String notifID;
    /// with Services
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "srvID")
    private Services services;
    //with contact
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Contact contact;
      @JsonIgnore
      @ManyToOne
      @JoinColumn(name = "jobTitleID")
      private JobTitle stafJob;

    public long getStaffID() {
        return staffID;
    }
    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }
    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    public Services getServices() {
        return services;
    }
    public void setServices(Services services) {
        this.services = services;
    }
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public JobTitle getStafJob() {
        return stafJob;
    }
    public void setStafJob(JobTitle stafJob) {
        this.stafJob = stafJob;
    }
    public String getNotifID() {
        return notifID;
    }
    public void setNotifID(String notifID) {
        this.notifID = notifID;
    }

}
