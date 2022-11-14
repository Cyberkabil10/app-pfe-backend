package com.allodoc.tn.covibed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.allodoc.tn.covibed.model.User;

public interface IUserDao extends JpaRepository<User, Long> {
    @Query("select usr from User usr where usr.username like :username")
    User findUSerByUserName(@Param("username") String username);
    @Query("select usr from User usr where usr.id like :id")
    User findUserByID(@Param("id") long id);
    @Query("select u from User u inner join Contact as c on u.id=c.user.id inner join Doctors as d on c.contactID=d.contact.contactID inner join Services as s on s.srvID=d.services.srvID inner join Organization o on o.orgID=s.organization.orgID  inner join City as ct on ct.cityID=c.cityContact.cityID  inner join Region as r on r.regionID= ct.cityRegion.regionID       where r.regionID like :regionid")
    List<User> finAllUserByRegion(@Param("regionid") long regionid );
    @Query("select u from User u inner join Contact c  on u.id=c.user.id inner join Doctors as d on c.contactID=d.contact.contactID inner join Services as s on s.srvID=d.services.srvID inner join Organization o on o.orgID=s.organization.orgID    where o.orgID like :orgID  ")
    List<User> finAllDctUserByOrg(@Param("orgID") long orgID);
    @Query("select u from User u inner join Contact c  on u.id=c.user.id inner join Staff as st on c.contactID=st.contact.contactID inner join Services as s on s.srvID=st.services.srvID inner join Organization o on o.orgID=s.organization.orgID    where o.orgID like :orgID  ")
    List<User> finAllStaffUserByOrg(@Param("orgID")long orgID);


    @Query("select case when count(user)> 0 then true else false end from User user where lower(user.username) like lower(:username)")
    boolean existsUserName(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("DELETE  FROM User user  where user.id like :id")
    void deleteUserById(@Param("id") long id);


    @Transactional
    @Modifying
    @Query(value = "delete from user_role where role_id=:role_id and user_id=:user_id ",nativeQuery = true)
    void deleteRole(@Param("role_id") long role_id,@Param("user_id") long user_id);
    @Query("select count(u.id) from User u inner join Contact as c on u.id=c.user.id   inner join City as ct on ct.cityID=c.cityContact.cityID  inner join Region as r on r.regionID= ct.cityRegion.regionID       where r.regionID like :regionid")
    int getUserCountbyRegion(@Param("regionid")long regionID);


    @Query("select u from User u inner join Contact c  on u.id=c.user.id inner join Doctors as d on c.contactID=d.contact.contactID  inner join JobTitle as jb on jb.jobTitleID =d.dctJob.jobTitleID     inner join Services as s on s.srvID=d.services.srvID     where s.srvID like :srvID and jb.jobTitleID=3 ")
    List<User> finAllGrdDctUserBySrv(@Param("srvID") long srvID);
    @Query("select u from User u inner join Contact c  on u.id=c.user.id inner join Staff as st on c.contactID=st.contact.contactID  inner join JobTitle as jb on jb.jobTitleID =st.stafJob.jobTitleID     inner join Services as s on s.srvID=st.services.srvID     where s.srvID like :srvID and jb.jobTitleID=2 ")
    User findSrvGenUserBySrv(@Param("srvID") long srvID);
    @Query("select u from User u inner join Contact c  on u.id=c.user.id inner join Staff as st on c.contactID=st.contact.contactID  inner join JobTitle as jb on jb.jobTitleID =st.stafJob.jobTitleID     inner join Services as s on s.srvID=st.services.srvID     inner join Organization o on o.orgID=s.organization.orgID  inner join City as ct on ct.cityID=c.cityContact.cityID  inner join Region as r on r.regionID= ct.cityRegion.regionID   where r.regionID like :regionid and jb.jobTitleID=4 ")
    User findDirecteurRegByReg(@Param("regionid")long regionID);
    @Query(value = "select * from covibed.user as u inner join covibed.user_role as ur on(u.id=ur.user_id) inner join covibed.role as  r on(ur.role_id=r.id) inner join covibed.contact as ct on u.id=ct.user_id inner join covibed.city as cty on cty.cityid=ct.cityid inner join covibed.region as reg on reg.regionid= cty.regionid where r.name='Admin' and reg.regionid=:regionid",nativeQuery = true)
    User findAdminyReg(@Param("regionid")long regionid);
}
