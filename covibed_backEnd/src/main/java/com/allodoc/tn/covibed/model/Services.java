package com.allodoc.tn.covibed.model;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Services")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@srvID")
public class Services implements Serializable {
  private static final long serialVersionUID = -6123703288245602356L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "srvID")
  private long srvID;

  @Column(name = "ServicesName")
  private String ServicesName;
  @Column(name = "imgurl")
    private String imgurl;

  @Column(name = "admin")
  private boolean admin;




@JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "orgID")
  private Organization organization;
//
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
  private List<Doctors> doctors;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
  private List<Staff> stuff;
  // with bed
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
    private List<Bed> bed;
  // with bed
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
    private List<TempBed> tmpbed;



  public long getSrvID() {
    return this.srvID;
  }

  public void setSrvID(long srvID) {
    this.srvID = srvID;
  }

  public String getServicesName() {
    return this.ServicesName;
  }

  public void setServicesName(String servicesName) {
    this.ServicesName = servicesName;
  }

public Organization getOrganization() {
    return organization;
}

public void setOrganization(Organization organization) {
    this.organization = organization;
}

public List<Doctors> getDoctors() {
    return doctors;
}

public void setDoctors(List<Doctors> doctors) {
    this.doctors = doctors;
}

public List<Staff> getStuff() {
    return stuff;
}

public void setStuff(List<Staff> stuff) {
    this.stuff = stuff;
}

public List<Bed> getBed() {
    return bed;
}

public void setBed(List<Bed> bed) {
    this.bed = bed;
}

public String getImgurl() {
    return imgurl;
}

public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
}

public boolean isAdmin() {
    return admin;
}

public void setAdmin(boolean admin) {
    this.admin = admin;
}

public List<TempBed> getTmpbed() {
    return tmpbed;
}

public void setTmpbed(List<TempBed> tmpbed) {
    this.tmpbed = tmpbed;
}


}