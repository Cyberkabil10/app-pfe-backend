package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.Country;

public interface ICountryDao  extends JpaRepository<Country, Long>{

    @Query("select cnt from Country cnt where cnt.countryID like :countryID")
    Country getCountryById(@Param("countryID") long countryID);
}
