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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "City")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@cityID")
public class City implements Serializable {
  private static final long serialVersionUID = -6123703288245602356L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cityID")
  private long cityID;

  @Column(name = "name")
  private String name;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "regionID")
  private Region cityRegion;

  @OneToMany(mappedBy = "cityContact")
  private List<Contact> contact;

  @OneToMany(mappedBy = "cityOrganization")
  private List<Organization> organizations;



  public String getName() {
    return this.name;
  }

  public long getCityID() {
    return cityID;
}

public void setCityID(long cityID) {
    this.cityID = cityID;
}

public Region getCityRegion() {
    return cityRegion;
}

public void setCityRegion(Region cityRegion) {
    this.cityRegion = cityRegion;
}

public void setName(String name) {
    this.name = name;
  }




}

