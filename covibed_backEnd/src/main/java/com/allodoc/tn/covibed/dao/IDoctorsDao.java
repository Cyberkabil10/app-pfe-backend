package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.allodoc.tn.covibed.model.Doctors;

public interface IDoctorsDao extends JpaRepository<Doctors, Long> {
    @Transactional
    @Modifying
    @Query("DELETE  FROM Doctors dct  where dct.doctorID like :doctorID")
    void deleteDocByID(@Param("doctorID") long doctorID);
}
