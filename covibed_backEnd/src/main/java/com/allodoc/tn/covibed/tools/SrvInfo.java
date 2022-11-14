package com.allodoc.tn.covibed.tools;

import java.util.List;

public class SrvInfo {
    private String srvNAme;
    private String orgNAme;
    private String regionName;
    private List<MailInfo> user;

    public String getSrvNAme() {
        return srvNAme;
    }

    public void setSrvNAme(String srvNAme) {
        this.srvNAme = srvNAme;
    }

    public List<MailInfo> getUser() {
        return user;
    }

    public void setUser(List<MailInfo> user) {
        this.user = user;
    }

    public String getOrgNAme() {
        return orgNAme;
    }

    public void setOrgNAme(String orgNAme) {
        this.orgNAme = orgNAme;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}
