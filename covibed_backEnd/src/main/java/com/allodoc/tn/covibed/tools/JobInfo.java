package com.allodoc.tn.covibed.tools;

import javax.persistence.Column;

public class JobInfo {
    private long jobTitleID;
    private String name;
    private String description;




    public long getJobTitleID() {
        return jobTitleID;
    }
    public void setJobTitleID(long jobTitleID) {
        this.jobTitleID = jobTitleID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



}
