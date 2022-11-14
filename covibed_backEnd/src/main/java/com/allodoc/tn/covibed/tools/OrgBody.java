package com.allodoc.tn.covibed.tools;

import java.util.List;

public class OrgBody {
private long orgID;
private String imgUrl;
private String orgName;
private String type;
private String imageName;
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
private List<ServicesBody> services;
public long getOrgID() {
    return orgID;
}
public void setOrgID(long orgID) {
    this.orgID = orgID;
}
public String getImgUrl() {
    return imgUrl;
}
public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
}
public String getOrgName() {
    return orgName;
}
public void setOrgName(String orgName) {
    this.orgName = orgName;
}
public List<ServicesBody> getServices() {
    return services;
}
public void setServices(List<ServicesBody> services) {
    this.services = services;
}
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
}
public String getImageName() {
    return imageName;
}
public void setImageName(String imageName) {
    this.imageName = imageName;
}


}
