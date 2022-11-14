package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.allodoc.tn.covibed.model.Staff;

public interface IStaffDao extends JpaRepository<Staff, Long> {
    @Transactional
    @Modifying
    @Query("DELETE  FROM Staff s  where s.staffID like :staffID")
    void deleteStaffcByID(@Param("staffID")long staffID);

}