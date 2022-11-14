package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.City;


public interface ICityDao extends JpaRepository<City, Long> {
    @Query("select city from City city where city.cityRegion.regionID like :regionID")
    List<City> findAllCityByReionID(@Param("regionID")  long regionID);

//   @Query("select city from Organization o INNER JOIN  City cty ON cty.cityID=o.cityOrganization.cityID  INNER JOIN Region r ON r.regionID=cty.cityRegion.regionID where r.regionID like  :regionID")
//   List<City> getAllCitiesWithOrgByRegionID(@Param("regionID")  long regionID);
    @Query("select c from City c inner join Organization o on o.cityOrganization.cityID=c.cityID inner join Region r on c.cityRegion=r.regionID  where r.regionID like  :regionID")
    List<City> getAllCitiesWithOrgByRegionID(@Param("regionID")  long regionID);

    @Query("select city from City city where city.cityID like :cityID")
    City getCityById(@Param("cityID") long cityID);
}
