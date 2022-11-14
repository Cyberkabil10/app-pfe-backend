package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.JobTitle;

public interface IJobTitleDao extends JpaRepository<JobTitle, Long>{
      @Query("select j from JobTitle j where j.jobTitleID like :jobTitleID")
    JobTitle findJobByID(@Param("jobTitleID")long jobTitleID);

}
