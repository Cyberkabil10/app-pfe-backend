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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

    @Entity
    @Table(name = "GeneralConfig")
    @Inheritance(strategy = InheritanceType.JOINED)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@configID")
    public class GeneralConfig implements Serializable {

        private static final long serialVersionUID = -6123703288245602356L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "configID")
        private long configID;
        @Column(name = "label")
        private String label;


        @OneToMany(fetch = FetchType.LAZY, mappedBy = "generalConfig")
        private List<OrgParameter> orgParameter;














        public List<OrgParameter> getOrgParameter() {
            return orgParameter;
        }
        public void setOrgParameter(List<OrgParameter> orgParameter) {
            this.orgParameter = orgParameter;
        }
        public long getConfigID() {
            return configID;
        }
        public void setConfigID(long configID) {
            this.configID = configID;
        }
        public String getLabel() {
            return label;
        }
        public void setLabel(String label) {
            this.label = label;
        }








}
