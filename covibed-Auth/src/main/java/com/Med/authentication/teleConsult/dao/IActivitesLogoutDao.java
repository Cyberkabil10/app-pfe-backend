package com.Med.authentication.teleConsult.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Med.authentication.teleConsult.model.ActivitesLogout;



public interface IActivitesLogoutDao extends JpaRepository<ActivitesLogout, Long>{
    @Query("select activites from ActivitesLogout activites where activites.username like :username order by activites.date desc")
    List<ActivitesLogout> getActivitesLogoutByUser(@Param("username") String username);

    @Query("select activites from ActivitesLogout activites where activites.date BETWEEN :datedebut and :datefin order by activites.date desc")
    List<ActivitesLogout> findActivitesByDate(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin);


    @Query("select activites from ActivitesLogout activites where activites.date BETWEEN :datedebut and :datefin and activites.username like :username order by activites.date desc")
    List<ActivitesLogout> findActivitesLogoutByUserBydate(@Param("datedebut")Date datedebut,@Param("datefin")Date datefin,@Param("username") String username);

    @Query("select activites from ActivitesLogout activites ORDER BY activites.date desc")
    List<ActivitesLogout> findAllByOrderByDateAsc();


}
