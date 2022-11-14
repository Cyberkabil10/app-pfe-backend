package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allodoc.tn.covibed.model.Role;

public interface IRoleDao extends JpaRepository<Role, Long> {

    @Query("select role from Role role where role.name  like :name")
    public Role getRoleByName(@Param("name") String name);

}
