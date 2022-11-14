package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.Organization;

public interface IOrganizationDao extends JpaRepository<Organization, Long> {
    @Query("select org from Organization org where org.admin = false and org.cityOrganization.cityID like :cityID")
    List<Organization> findAllOrganisationBYCityID(@Param("cityID")long cityID);

      @Query("select org from Organization org where org.orgID like :orgID")
      Organization getOrganizationById(@Param("orgID") long orgID);

      @Query("select org from Organization org INNER JOIN City city ON city.cityID = org.cityOrganization.cityID INNER JOIN Region reg ON reg.regionID = city.cityRegion.regionID where org.admin=false and reg.regionID like :regionID ")
        List<Organization> findAllOrganisationByRegionID(@Param("regionID")long regionID);

      @Query("select org from Organization org INNER JOIN OrgParameter orgParm on org.orgID=orgParm.organization.orgID INNER JOIN GeneralConfig gnConf on gnConf.configID=orgParm.generalConfig.configID   INNER JOIN City city ON city.cityID = org.cityOrganization.cityID INNER JOIN Region reg ON reg.regionID = city.cityRegion.regionID where org.admin=false and reg.regionID like :regionID and gnConf.configID =1 ")
      List<Organization> findAllOrganisationByRegionIDWithServicesEmailActive(@Param("regionID")long regionID);


}
