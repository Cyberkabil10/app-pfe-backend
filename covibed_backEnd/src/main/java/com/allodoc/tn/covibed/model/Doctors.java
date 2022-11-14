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
@Table(name = "Doctors")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@doctorID")
public class Doctors implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorID")
    private long doctorID;

    @Column(name = "institut")
    private String institut;
    @Column(name = "diplome")
    private String diplome;
    @Column(name = "grade")
    private String grade;
    @Column(name = "specialite")
    private String specialite;
    @Column(name = "fonction")
    private String fonction;
    @Column(name = "notifID")
    private String notifID;


    //// with contact
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Contact contact;

    /// with Services
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "srvID")
    private Services services;

      @JsonIgnore
      @ManyToOne
      @JoinColumn(name = "jobTitleID")
      private JobTitle dctJob;


    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }






    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public String getNotifID() {
        return notifID;
    }

    public void setNotifID(String notifID) {
        this.notifID = notifID;
    }

    public JobTitle getDctJob() {
        return dctJob;
    }

    public void setDctJob(JobTitle dctJob) {
        this.dctJob = dctJob;
    }

}
