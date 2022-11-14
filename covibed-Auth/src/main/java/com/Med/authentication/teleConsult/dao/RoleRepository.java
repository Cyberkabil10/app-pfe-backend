package com.Med.authentication.teleConsult.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Med.authentication.teleConsult.model.Role;



@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role getRoleById(int id);


}
