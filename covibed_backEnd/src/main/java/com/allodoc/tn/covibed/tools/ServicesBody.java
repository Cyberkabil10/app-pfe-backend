package com.allodoc.tn.covibed.tools;

public class ServicesBody {
private long srvID;
private String srvName;
private String imgUrl;
private String imageName;
private long orgID;
private String cityName;
private String regionName;




public String getCityName() {
    return cityName;
}
public void setCityName(String cityName) {
    this.cityName = cityName;
}
public String getRegionName() {
    return regionName;
}
public void setRegionName(String regionName) {
    this.regionName = regionName;
}
public long getOrgID() {
    return orgID;
}
public void setOrgID(long orgID) {
    this.orgID = orgID;
}
public String getImageName() {
    return imageName;
}
public void setImageName(String imageName) {
    this.imageName = imageName;
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
public String getImgUrl() {
    return imgUrl;
}
public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
}

}
