package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.License;

public interface ILicenseDao extends JpaRepository<License, Long>{
     @Query("select l from License l where l.region.regionID like :regionID")
    License findLicensebyRegion(@Param("regionID")long regionID);

}
