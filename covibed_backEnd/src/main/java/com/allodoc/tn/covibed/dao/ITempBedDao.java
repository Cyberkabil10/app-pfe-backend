package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.TempBed;

public interface ITempBedDao extends JpaRepository<TempBed, Long>{
    @Query(value="SELECT * FROM covibed.temp_bed as b where b.availability=true and b.srv_id is null ORDER BY b.temp_bedid asc LIMIT 1;", nativeQuery=true)
    TempBed findAvailbaltmpBed();
    @Query("select b from TempBed b where b.tempBedID  like :tempBedID")
    TempBed findTmpBedByID(@Param("tempBedID")long tempBedID);

    @Query("select b from TempBed b where b.services.srvID like :srvID ")
    List<TempBed> findAllTmpBedBysrvID(@Param("srvID") long srvID);
    //stat by org ID
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID")
    int totalTmpBedCountByOrg(@Param("orgID") long orgID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.availability=true")
    int totalTmpBedAvailbalByOrg(@Param("orgID") long orgID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.intubation=true")
    int totalTmpIntubationByOrg(@Param("orgID") long orgID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.gravity=1")
    int totalTmpMinorByOrg(@Param("orgID") long orgID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.gravity=2")
    int totalTmpMajorByOrg(@Param("orgID") long orgID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.gravity=3")
    int totalTmpCriticalByOrg(@Param("orgID") long orgID);
    @Query("select SUM(b.o2) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID ")
    int totalTmpO2ByOrg(@Param("orgID") long orgID);
    //stat by Srv ID
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where  s.admin=false and s.srvID like :srvID")
    int totalTmpBedCountBySrv(@Param("srvID")long srvID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.availability=true")
    int totalTmpBedAvailbalBySrv(@Param("srvID") long srvID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.intubation=true")
    int totalTmpIntubationBySrv(@Param("srvID") long srvID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.gravity=1")
    int totalTmpMinorBySrv(@Param("srvID") long srvID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.gravity=2")
    int totalTmpMajorBySrv(@Param("srvID") long srvID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.gravity=3")
    int totalTmpCriticalBySrv(@Param("srvID") long srvID);
    @Query("select SUM(b.o2) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID ")
    int totalTmpO2BySrv(@Param("srvID") long srvID);
    ////stat by region
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID")
    int totalTmpBedCountByRegion(@Param("regionID") long regionID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.availability=true")
    int totalTmpBedAvailbalByRegion(@Param("regionID") long regionID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.intubation=true")
    int totalTmpIntubationByRegion(@Param("regionID") long regionID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.gravity=1")
    int totalTmpMinorByRegion(@Param("regionID") long regionID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.gravity=2")
    int totalTmpMajorByRegion(@Param("regionID") long regionID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.gravity=3")
    int totalTmpCriticalByRegion(@Param("regionID") long regionID);
    @Query("select SUM(b.o2) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID ")
    int totalTmpO2ByRegion(@Param("regionID") long regionID);

    ///stat by country id
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID")
    int totalTmpBedCountByCountry(@Param("countryID") long countryID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID and b.availability=true")
    int totalTmpBedAvailbalByCountry(@Param("countryID") long countryID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.intubation=true")
    int totalTmpIntubationByCountry(@Param("countryID") long countryID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.gravity=1")
    int totalTmpMinorByCountry(@Param("countryID") long countryID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.gravity=2")
    int totalTmplMajorByCountry(@Param("countryID") long countryID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.gravity=3")
    int totalTmpCriticalByCountry(@Param("countryID") long countryID);
    @Query("select SUM(b.o2) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID")
    int totalTmpO2ByCountry(@Param("countryID") long countryID);
    ////stat by city id


    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID")
    int totalTmpBedCountByCity(@Param("cityID")long cityID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID and b.availability=true")
    int totalTmpBedAvailbalByCity(@Param("cityID")long cityID);
    @Query("select Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID and b.intubation=true")
    int totalTmpIntubationByCity(@Param("cityID")long cityID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and  cty.cityID like :cityID and b.gravity=1")
    int totalTmpMinorByCity(@Param("cityID") long cityID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where  o.admin=false and s.admin=false and cty.cityID like :cityID and b.gravity=2")
    int totalTmpMajorByCity(@Param("cityID") long cityID);
    @Query("select  Count(b.tempBedID) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID and b.gravity=3")
    int totalTmpCriticalByCity(@Param("cityID") long cityID);
    @Query("select SUM(b.o2) from TempBed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID ")
    int totalTmpO2ByCity(@Param("cityID") long cityID);
}
