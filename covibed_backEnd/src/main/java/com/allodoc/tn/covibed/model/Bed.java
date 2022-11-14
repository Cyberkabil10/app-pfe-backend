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
@Table(name = "Bed")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@bedID")
public class Bed implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bedID")
    private long bedID;
    @Column(name = "label")
    private String label;
    @Column(name = "o2")
    private int o2;
    @Column(name = "intubation")
    private boolean intubation;

    @Column(name = "gravity")
    private int gravity;

    @Column(name = "availability")
    private boolean availability;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "srvId")
    private Services services;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private QrCodeDetail qrCode;
    public long getBedID() {
        return bedID;
    }
    public void setBedID(long bedID) {
        this.bedID = bedID;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public int getO2() {
        return o2;
    }
    public void setO2(int o2) {
        this.o2 = o2;
    }
    public boolean isIntubation() {
        return intubation;
    }
    public void setIntubation(boolean intubation) {
        this.intubation = intubation;
    }
    public int getGravity() {
        return gravity;
    }
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public Services getServices() {
        return services;
    }
    public void setServices(Services services) {
        this.services = services;
    }
    public QrCodeDetail getQrCode() {
        return qrCode;
    }
    public void setQrCode(QrCodeDetail qrCode) {
        this.qrCode = qrCode;
    }

}
