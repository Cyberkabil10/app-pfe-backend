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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

    @Entity
    @Table(name = "ProfileCategory")
    @Inheritance(strategy = InheritanceType.JOINED)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@profileCategoryID")
    public class ProfileCategory implements Serializable {
      private static final long serialVersionUID = -6123703288245602356L;

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name = "profileCategoryID")
      private long profileCategoryID;

      @Column(name = "name")
      private String name;
      @Column(name = "description")
      private String description;


          @OneToMany(mappedBy = "profileCategory")
        private List<JobTitle> jobTitle;


        public long getProfileCategoryID() {
            return profileCategoryID;
        }


        public void setProfileCategoryID(long profileCategoryID) {
            this.profileCategoryID = profileCategoryID;
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


        public List<JobTitle> getJobTitle() {
            return jobTitle;
        }


        public void setJobTitle(List<JobTitle> jobTitle) {
            this.jobTitle = jobTitle;
        }









}
