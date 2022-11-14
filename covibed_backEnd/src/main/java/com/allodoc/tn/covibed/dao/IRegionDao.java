package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.Region;

public interface IRegionDao  extends JpaRepository<Region , Long>{
    @Query("select reg from Region reg where reg.coutryRegion.countryID like :countryID")
    List<Region> findAllRegionByContryID(@Param("countryID") long countryID);

    @Query("select r from Region r where  r.regionID IN  (SELECT distinct rr.regionID from  Region rr INNER JOIN City cc on cc.cityRegion=rr.regionID INNER JOIN Organization oo ON oo.cityOrganization.cityID=cc.cityID)  ")
    List<Region> findAllRegionWithOrgByContryID(@Param("countryID") long countryID);

    @Query("select reg from Region reg where reg.regionID like :regionID")
    Region getRegionById(@Param("regionID") long regionID);

}
