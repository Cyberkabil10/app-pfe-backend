package com.allodoc.tn.covibed.tools;

import java.util.List;

import javax.persistence.Column;

public class UserInfo {
    private long userID;
    private String userName;
    private String nom;
    private String prenom;
    private String email;
    private String phoneNumber;
    private String sexe;
    private String Age;
    private long cityID;
    private String cityName;
    private String fonction;
    private long orgID;
    private String orgName;
    private long srvID;
    private String srvName;
    private List<RoleInfo> roles;
    private long dctID;
    private long staffID;
    private long contactID;
    private long profileCategoryID;
    private String profileName;
    private long jobTitleID;
    private String JobName;
    private boolean servadmin;
    private boolean orgAdmin;

    private long regionID;
    private long countryID;
    private String regionName;
    private String countryName;

    public boolean isServadmin() {
        return servadmin;
    }

    public void setServadmin(boolean servadmin) {
        this.servadmin = servadmin;
    }

    public boolean isOrgAdmin() {
        return orgAdmin;
    }

    public void setOrgAdmin(boolean orgAdmin) {
        this.orgAdmin = orgAdmin;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public long getCountryID() {
        return countryID;
    }

    public void setCountryID(long countryID) {
        this.countryID = countryID;
    }

    private String notifID;

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public long getOrgID() {
        return orgID;
    }

    public void setOrgID(long orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public long getSrvID() {
        return srvID;
    }

    public void setSrvID(long srvID) {
        this.srvID = srvID;
    }

    public String getSrvName() {
        return srvName;
    }

    public void setSrvName(String srvName) {
        this.srvName = srvName;
    }

    public List<RoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleInfo> role) {
        this.roles = role;
    }

    public long getDctID() {
        return dctID;
    }

    public void setDctID(long dctID) {
        this.dctID = dctID;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public long getProfileCategoryID() {
        return profileCategoryID;
    }

    public void setProfileCategoryID(long profileCategoryID) {
        this.profileCategoryID = profileCategoryID;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public long getJobTitleID() {
        return jobTitleID;
    }

    public void setJobTitleID(long jobTitleID) {
        this.jobTitleID = jobTitleID;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String jobName) {
        JobName = jobName;
    }

    public String getNotifID() {
        return notifID;
    }

    public void setNotifID(String notifID) {
        this.notifID = notifID;
    }

}
