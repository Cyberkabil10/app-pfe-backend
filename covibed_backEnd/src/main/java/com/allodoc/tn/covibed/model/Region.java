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
@Table(name = "Region")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@regionID")
public class Region implements Serializable {
  private static final long serialVersionUID = -6123703288245602356L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "regionID")
  private long regionID;

  @Column(name = "name")
  private String name;

  @Column(name = "lat")
  private Double lat;

  @Column(name = "lng")
  private Double lng;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "countryID")
  private Country coutryRegion;

  @OneToMany(mappedBy = "cityRegion")
  private List<City> city;
  @OneToMany(mappedBy = "region")
  private List<License> license;

  public long getRegionID() {
    return this.regionID;
  }

  public void setRegionID(long regionID) {
    this.regionID = regionID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }




public Country getCoutryRegion() {
    return coutryRegion;
}

public void setCoutryRegion(Country coutryRegion) {
    this.coutryRegion = coutryRegion;
}

public List<City> getCity() {
    return city;
}

public void setCity(List<City> city) {
    this.city = city;
}

public Double getLat() {
    return this.lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Double getLng() {
    return this.lng;
  }

  public void setLng(Double lng) {
    this.lng = lng;
  }



}
