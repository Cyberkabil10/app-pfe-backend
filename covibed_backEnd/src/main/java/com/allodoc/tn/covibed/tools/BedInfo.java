package com.allodoc.tn.covibed.tools;

public class BedInfo {
    private long bedID;
    private long srvcID;
    private String label;
    private String qrCode;
    private boolean availability;
    private int gravity;
    private boolean intubation;
    private int o2;
    private int totalBeds;
    private int totalavailbal;
    private int totalIntubation;
    private int minor;
    private int major;
    private int critical;
    private String orgName;
    private String svcName;
    private long orgID;
    private String type;











    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
    public String getSvcName() {
        return svcName;
    }
    public void setSvcName(String svcName) {
        this.svcName = svcName;
    }
    public int getTotalIntubation() {
        return totalIntubation;
    }
    public void setTotalIntubation(int totalIntubation) {
        this.totalIntubation = totalIntubation;
    }
    public long getBedID() {
        return bedID;
    }
    public void setBedID(long bedID) {
        this.bedID = bedID;
    }
    public long getSrvcID() {
        return srvcID;
    }
    public void setSrvcID(long srvcID) {
        this.srvcID = srvcID;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getQrCode() {
        return qrCode;
    }
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public int getGravity() {
        return gravity;
    }
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }
    public boolean isIntubation() {
        return intubation;
    }
    public void setIntubation(boolean intubation) {
        this.intubation = intubation;
    }
    public int getO2() {
        return o2;
    }
    public void setO2(int o2) {
        this.o2 = o2;
    }
    public int getTotalBeds() {
        return totalBeds;
    }
    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }
    public int getMinor() {
        return minor;
    }
    public void setMinor(int minor) {
        this.minor = minor;
    }
    public int getMajor() {
        return major;
    }
    public void setMajor(int major) {
        this.major = major;
    }
    public int getCritical() {
        return critical;
    }
    public void setCritical(int critical) {
        this.critical = critical;
    }
    public int getTotalavailbal() {
        return totalavailbal;
    }
    public void setTotalavailbal(int totalavailbal) {
        this.totalavailbal = totalavailbal;
    }

}
