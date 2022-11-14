package com.allodoc.tn.covibed.model;

import java.io.Serializable;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

    @Entity
    @Table(name = "OrgParameter")
    @Inheritance(strategy = InheritanceType.JOINED)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@orgPrID")
    public class OrgParameter implements Serializable {

        private static final long serialVersionUID = -6123703288245602356L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "orgPrID")
        private long orgPrID;


          @JsonIgnore
          @ManyToOne(fetch = FetchType.LAZY)
          @JoinColumn(name = "orgID")
          private Organization organization;

          @JsonIgnore
          @ManyToOne(fetch = FetchType.LAZY)
          @JoinColumn(name = "configID")
          private GeneralConfig generalConfig;

        public long getOrgPrID() {
            return orgPrID;
        }

        public void setOrgPrID(long orgPrID) {
            this.orgPrID = orgPrID;
        }

        public Organization getOrganization() {
            return organization;
        }

        public void setOrganization(Organization organization) {
            this.organization = organization;
        }

        public GeneralConfig getGeneralConfig() {
            return generalConfig;
        }

        public void setGeneralConfig(GeneralConfig generalConfig) {
            this.generalConfig = generalConfig;
        }












}
