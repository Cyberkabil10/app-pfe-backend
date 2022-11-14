package com.allodoc.tn.covibed.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Country")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@countryID")
public class Country implements Serializable {
  private static final long serialVersionUID = -6123703288245602356L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "countryID")
  private long countryID;

  @Column(name = "cca2")
  private String cca2;

  @Column(name = "cca3")
  private String cca3;

  @Column(name = "capital")
  private String capital;

  @Column(name = "subregion")
  private String subregion;

  @Column(name = "NomEng")
  private String NomEng;

  @Column(name = "NomFr")
  private String NomFr;

  @Column(name = "lattitude")
  private float lattitude;

  @Column(name = "longitude")
  private float longitude;

  @Column(name = "phoneCode")
  private int phoneCode;
//
//  @OneToMany(mappedBy = "paysContact")
//  private List<Contact> contact;

  @OneToMany(mappedBy = "coutryRegion")
  private List<Region> region;



  public long getCountryID() {
    return countryID;
}

public void setCountryID(long countryID) {
    this.countryID = countryID;
}

public String getCca2() {
    return this.cca2;
  }

  public void setCca2(String cca2) {
    this.cca2 = cca2;
  }

  public String getCca3() {
    return this.cca3;
  }

  public void setCca3(String cca3) {
    this.cca3 = cca3;
  }

  public String getCapital() {
    return this.capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public String getSubregion() {
    return this.subregion;
  }

  public void setSubregion(String subregion) {
    this.subregion = subregion;
  }

  public String getNomEng() {
    return this.NomEng;
  }

  public void setNomEng(String nomEng) {
    this.NomEng = nomEng;
  }

  public String getNomFr() {
    return this.NomFr;
  }

  public void setNomFr(String nomFr) {
    this.NomFr = nomFr;
  }

  public float getLattitude() {
    return this.lattitude;
  }

  public void setLattitude(float lattitude) {
    this.lattitude = lattitude;
  }

  public float getLongitude() {
    return this.longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

//  public List<Contact> getContact() {
//    return this.contact;
//  }
//
//  public void setContact(List<Contact> contact) {
//    this.contact = contact;
//  }

  public List<Region> getRegion() {
    return this.region;
  }

  public void setRegion(List<Region> region) {
    this.region = region;
  }

  public int getPhoneCode() {
    return this.phoneCode;
  }

  public void setPhoneCode(int phoneCode) {
    this.phoneCode = phoneCode;
  }
}

