package com.allodoc.tn.covibed.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "QrCodeDetail")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@qrID")
public class QrCodeDetail implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qrID")
    private long qrID;
    @Column(name = "storagepath")
    private String storagepath;

    @Column(name = "url")
    private String url;

    @Column(name = "hashids")
    private String hashids;

    @JsonIgnore
    @OneToOne(mappedBy = "qrCode")
    private Bed bed;

    public long getQrID() {
        return qrID;
    }

    public void setQrID(long qrID) {
        this.qrID = qrID;
    }

    public String getStoragepath() {
        return storagepath;
    }

    public void setStoragepath(String storagepath) {
        this.storagepath = storagepath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHashids() {
        return hashids;
    }

    public void setHashids(String hashids) {
        this.hashids = hashids;
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }


}