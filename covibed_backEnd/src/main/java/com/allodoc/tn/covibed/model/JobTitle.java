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
@Table(name = "JobTitle")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jobTitleID")
public class JobTitle implements Serializable {

    private static final long serialVersionUID = -6123703288245602356L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jobTitleID")
    private long jobTitleID;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    /// with jb category
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profileCategoryID")
    private ProfileCategory profileCategory;
    // with dct
    @OneToMany(mappedBy = "dctJob")
    private List<Doctors> doctors;
    // with stuff
    @OneToMany(mappedBy = "stafJob")
    private List<Staff> staff;

    public long getJobTitleID() {
        return jobTitleID;
    }

    public void setJobTitleID(long jobTitleID) {
        this.jobTitleID = jobTitleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProfileCategory getProfileCategory() {
        return profileCategory;
    }

    public void setProfileCategory(ProfileCategory profileCategory) {
        this.profileCategory = profileCategory;
    }

    public List<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctors> doctors) {
        this.doctors = doctors;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

}
