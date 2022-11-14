package com.allodoc.tn.covibed.tools;

import java.util.List;

public class MailBody {
    private String orgName;
    private String regioName;
    private List<SrvInfo> services;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRegioName() {
        return regioName;
    }

    public void setRegioName(String regioName) {
        this.regioName = regioName;
    }

    public List<SrvInfo> getServices() {
        return services;
    }

    public void setServices(List<SrvInfo> services) {
        this.services = services;
    }

}
