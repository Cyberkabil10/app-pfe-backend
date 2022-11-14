package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.allodoc.tn.covibed.model.Contact;

public interface IContactDao extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c inner join User u  on u.id=c.user.id inner join Doctors as d on c.contactID=d.contact.contactID inner join Services as s on s.srvID=d.services.srvID inner join Organization o on o.orgID=s.organization.orgID  inner join City as ct on ct.cityID=c.cityContact.cityID  inner join Region as r on r.regionID= ct.cityRegion.regionID   where r.regionID like :regionid  ")
    List<Contact> finAllContactByRegion(@Param("regionid") long regionid );
    @Query("select c from Contact c where c.contactID like:contactID")
    Contact findContactById(@Param("contactID") long contactID);
    @Transactional
    @Modifying
    @Query("DELETE  FROM Contact c  where c.contactID like :contactID")
    void deleteConatctByID(@Param("contactID") long contactID);


}
