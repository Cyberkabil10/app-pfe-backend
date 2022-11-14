package com.allodoc.tn.covibed.tools;

import javax.persistence.Column;

public class LicenseInfo {
    private long licenseID;
    private int nbr;
    private long regionID;
    private int userNbr;










    public long getLicenseID() {
        return licenseID;
    }
    public void setLicenseID(long licenseID) {
        this.licenseID = licenseID;
    }
    public int getNbr() {
        return nbr;
    }
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
    public long getRegionID() {
        return regionID;
    }
    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }
    public int getUserNbr() {
        return userNbr;
    }
    public void setUserNbr(int userNbr) {
        this.userNbr = userNbr;
    }

}
