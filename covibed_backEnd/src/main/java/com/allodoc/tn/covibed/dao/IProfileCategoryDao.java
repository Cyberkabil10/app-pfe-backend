package com.allodoc.tn.covibed.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allodoc.tn.covibed.model.ProfileCategory;

public interface IProfileCategoryDao extends JpaRepository<ProfileCategory, Long> {

}
