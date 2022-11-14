package com.allodoc.tn.covibed.model;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Organization")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@orgID")
public class Organization implements Serializable {
    private static final long serialVersionUID = -4672774270950713417L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orgID")
    private long orgID;

    @Column(name = "orgName")
    private String orgName;

    @Column(name = "logo")
    private String logo;
    @Column(name = "imgurl")
    private String imgurl;
    @Column(name = "type")
    private String type;

    @Column(name = "admin")
    private boolean admin;


    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    private List<Services> services;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    private List<OrgParameter> orgParameter;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(unique = true)
//    private Contact contact;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cityID")
    private City cityOrganization;

    public long getOrgID() {
        return this.orgID;
    }

    public void setOrgID(long orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return this.orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public City getCity() {
        return this.cityOrganization;
    }

    public void setCity(City city) {
        this.cityOrganization = city;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OrgParameter> getOrgParameter() {
        return orgParameter;
    }

    public void setOrgParameter(List<OrgParameter> orgParameter) {
        this.orgParameter = orgParameter;
    }

//    public Contact getContact() {
//        return contact;
//    }
//
//    public void setContact(Contact contact) {
//        this.contact = contact;
//    }

}
