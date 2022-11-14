package com.allodoc.tn.covibed.tools;

import java.util.List;

public class BedStatInfo {
private long countryID;
private String countryName;
private long regionID;
private String regionName;
private  long cityID;
private String cityName;
private  long orgID;
private String orgName;
private long svcID;
private String svcName;
private List<BedInfo> bed;
private List<BedInfo> tmpbed;
private String type;
private String orgImg;
private String srvImg;








public List<BedInfo> getTmpbed() {
    return tmpbed;
}
public void setTmpbed(List<BedInfo> tmpbed) {
    this.tmpbed = tmpbed;
}
public String getSrvImg() {
    return srvImg;
}
public void setSrvImg(String srvImg) {
    this.srvImg = srvImg;
}
public String getOrgImg() {
    return orgImg;
}
public void setOrgImg(String orgImg) {
    this.orgImg = orgImg;
}
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
}
public long getCountryID() {
    return countryID;
}
public void setCountryID(long countryID) {
    this.countryID = countryID;
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
public String getRegionName() {
    return regionName;
}
public void setRegionName(String regionName) {
    this.regionName = regionName;
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
public long getSvcID() {
    return svcID;
}
public void setSvcID(long svcID) {
    this.svcID = svcID;
}
public String getSvcName() {
    return svcName;
}
public void setSvcName(String svcName) {
    this.svcName = svcName;
}
public List<BedInfo> getBed() {
    return bed;
}
public void setBed(List<BedInfo> bed) {
    this.bed = bed;
}

}
