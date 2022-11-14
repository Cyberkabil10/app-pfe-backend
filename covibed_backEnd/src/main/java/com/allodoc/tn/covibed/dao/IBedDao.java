package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.Bed;

public interface IBedDao extends JpaRepository<Bed, Long> {
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID")
    int totalBedCountByCountry(@Param("countryID") long countryID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID and b.availability=true")
    int totalBedAvailbalByCountry(@Param("countryID") long countryID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.intubation=true")
    int totalIntubationByCountry(@Param("countryID") long countryID);
    @Query("select SUM(b.o2) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID")
    int totalO2ByCountry(@Param("countryID") long countryID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.gravity=1")
    int totalMinorByCountry(@Param("countryID") long countryID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.gravity=2")
    int totalMajorByCountry(@Param("countryID") long countryID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID INNER JOIN Country cnt ON cnt.countryID=reg.coutryRegion.countryID where o.admin=false and s.admin=false and cnt.countryID like :countryID  and b.gravity=3")
    int totaCriticalByCountry(@Param("countryID") long countryID);
    //
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID")
    int totalBedCountByRegion(@Param("regionID") long regionID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.availability=true")
    int totalBedAvailbalByRegion(@Param("regionID") long regionID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.intubation=true")
    int totalIntubationByRegion(@Param("regionID") long regionID);
    @Query("select SUM(b.o2) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID ")
    int totalO2ByRegion(@Param("regionID") long regionID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.gravity=1")
    int totalMinorByRegion(@Param("regionID") long regionID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.gravity=2")
    int totalMajorByRegion(@Param("regionID") long regionID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region reg on reg.regionID=cty.cityRegion.regionID where o.admin=false and s.admin=false and reg.regionID like :regionID and b.gravity=3")
    int totaCriticalByRegion(@Param("regionID") long regionID);
    /////city
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID")
    int totalBedCountByCity(@Param("cityID")long cityID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID and b.availability=true")
    int totalBedAvailbalByCity(@Param("cityID")long cityID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID and b.intubation=true")
    int totalIntubationByCity(@Param("cityID")long cityID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and  cty.cityID like :cityID and b.gravity=1")
    int totalMinorByCity(@Param("cityID") long cityID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where  o.admin=false and s.admin=false and cty.cityID like :cityID and b.gravity=2")
    int totalMajorByCity(@Param("cityID") long cityID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID and b.gravity=3")
    int totaCriticalByCity(@Param("cityID") long cityID);
    @Query("select SUM(b.o2) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  where o.admin=false and s.admin=false and cty.cityID like :cityID ")
    int totalO2ByCity(@Param("cityID") long cityID);
    ///organisation
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID")
    int totalBedCountByOrg(@Param("orgID") long orgID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.availability=true")
    int totalBedAvailbalByOrg(@Param("orgID") long orgID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.intubation=true")
    int totalIntubationByOrg(@Param("orgID") long orgID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.gravity=1")
    int totalMinorByOrg(@Param("orgID") long orgID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.gravity=2")
    int totalMajorByOrg(@Param("orgID") long orgID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID and b.gravity=3")
    int totaCriticalByOrg(@Param("orgID") long orgID);
    @Query("select SUM(b.o2) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID INNER JOIN Organization o ON o.orgID=s.organization.orgID where o.admin=false and s.admin=false and o.orgID like :orgID ")
    int totalO2ByOrg(@Param("orgID") long orgID);
    ///services
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where  s.admin=false and s.srvID like :srvID")
    int totalBedCountBySrv(@Param("srvID") long srvID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.availability=true")
    int totalBedAvailbalBySrv(@Param("srvID") long srvID);
    @Query("select Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.intubation=true")
    int totalIntubationBySrv(@Param("srvID") long srvID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.gravity=1")
    int totalMinorBySrv(@Param("srvID") long srvID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.gravity=2")
    int totalMajorBySrv(@Param("srvID") long srvID);
    @Query("select  Count(b.bedID) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID and b.gravity=3")
    int totaCriticalBySrv(@Param("srvID") long srvID);
    @Query("select SUM(b.o2) from Bed b INNER JOIN Services s ON s.srvID=b.services.srvID  where s.admin=false and s.srvID like :srvID ")
    int totalO2BySrv(@Param("srvID") long srvID);
    @Query("select b from Bed b where b.bedID like :bedID ")
    Bed findBedInfoById(@Param("bedID")long bedID);
}
