package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.Services;

public interface IServicesDao extends JpaRepository<Services, Long> {
    @Query("select svc from Services svc where svc.admin=false and svc.organization.orgID like :orgID")
    List<Services> findAllServicesByOrgID(@Param("orgID")  long orgID);
    @Query("select svc from Services svc where svc.admin=false and svc.srvID like :srvID")
    Services findServicesID(@Param("srvID")  long srvID);

    @Query("select svc from Services svc where svc.srvID like :svcID")
    Services getServiceById(@Param("svcID") long svcID);
    @Query("select svc from Services svc where svc.organization.orgID like :orgID")
    List<Services> filAllServiices(@Param("orgID")  long orgID);

}
