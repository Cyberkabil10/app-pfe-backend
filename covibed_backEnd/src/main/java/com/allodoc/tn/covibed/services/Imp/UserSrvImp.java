package com.allodoc.tn.covibed.services.Imp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IContactDao;
import com.allodoc.tn.covibed.dao.IDoctorsDao;
import com.allodoc.tn.covibed.dao.IJobTitleDao;
import com.allodoc.tn.covibed.dao.IRoleDao;
import com.allodoc.tn.covibed.dao.IServicesDao;
import com.allodoc.tn.covibed.dao.IStaffDao;
import com.allodoc.tn.covibed.dao.IUserDao;
import com.allodoc.tn.covibed.model.Contact;
import com.allodoc.tn.covibed.model.Doctors;
import com.allodoc.tn.covibed.model.JobTitle;
import com.allodoc.tn.covibed.model.Role;
import com.allodoc.tn.covibed.model.Services;
import com.allodoc.tn.covibed.model.Staff;
import com.allodoc.tn.covibed.model.User;
import com.allodoc.tn.covibed.services.IUserService;
import com.allodoc.tn.covibed.tools.RoleInfo;
import com.allodoc.tn.covibed.tools.UserBody;
import com.allodoc.tn.covibed.tools.UserInfo;

@Service
public class UserSrvImp implements IUserService {
    @Autowired
    IUserDao usrDao;
    @Autowired
    IContactDao ctnDao;
    @Autowired
    IServicesDao srvDao;
    @Autowired
    IJobTitleDao jbDao;
    @Autowired
    IRoleDao roleDao;
    @Autowired
    IStaffDao stfDao;

    @Autowired
    IDoctorsDao dctDao;

    @Override
    public UserInfo getUserInfo(String userName) {
        User usr = usrDao.findUSerByUserName(userName);
        // userInfo
        UserInfo result = new UserInfo();
        result.setUserID(usr.getId());
        result.setUserName(userName);
        List<Role> r = usr.getRoles();
        List<RoleInfo> role = new ArrayList<RoleInfo>();
        for (Role rr : r) {
            RoleInfo ri = new RoleInfo();
            ri.setRoleID(rr.getId());
            ri.setName(rr.getName());
            role.add(ri);
        }
        result.setRoles(role);

        // cntact info
        Contact c = usr.getContact();

        result.setContactID(c.getContactID());
        result.setAge(c.getAge());
        result.setNom(c.getNom());
        result.setPrenom(c.getPrenom());
        result.setSexe(c.getSex());
        result.setEmail(c.getEmail());
        result.setPhoneNumber(c.getPhoneNumber());
        result.setContactID(c.getContactID());
        result.setCityID(c.getCityContact().getCityID());
        result.setCityName(c.getCityContact().getName());
        result.setCountryID(c.getCityContact().getCityRegion().getCoutryRegion().getCountryID());
        result.setRegionID(c.getCityContact().getCityRegion().getRegionID());
        result.setRegionName(c.getCityContact().getCityRegion().getName());
        result.setCountryName(c.getCityContact().getCityRegion().getCoutryRegion().getNomFr());
        //// doctor info
        if (c.getDoctors() != null) {
            result.setDctID(c.getDoctors().getDoctorID());
            result.setFonction(c.getDoctors().getFonction());
            result.setNotifID(c.getDoctors().getNotifID());
            result.setOrgID(c.getDoctors().getServices().getOrganization().getOrgID());
            result.setOrgName(c.getDoctors().getServices().getOrganization().getOrgName());
            result.setSrvID(c.getDoctors().getServices().getSrvID());
            result.setSrvName(c.getDoctors().getServices().getServicesName());
            result.setJobName(c.getDoctors().getDctJob().getName());
            result.setJobTitleID(c.getDoctors().getDctJob().getJobTitleID());
            result.setProfileCategoryID(c.getDoctors().getDctJob().getProfileCategory().getProfileCategoryID());
            result.setProfileName(c.getDoctors().getDctJob().getProfileCategory().getName());
            result.setFonction(c.getDoctors().getFonction());
            result.setServadmin(c.getDoctors().getServices().isAdmin());
            result.setOrgAdmin(c.getDoctors().getServices().getOrganization().isAdmin());
        }
        // staff info
        if (c.getStaff() != null) {
            result.setStaffID(c.getStaff().getStaffID());
            result.setNotifID(c.getStaff().getNotifID());
            result.setOrgID(c.getStaff().getServices().getOrganization().getOrgID());
            result.setOrgName(c.getStaff().getServices().getOrganization().getOrgName());
            result.setSrvID(c.getStaff().getServices().getSrvID());
            result.setSrvName(c.getStaff().getServices().getServicesName());
            result.setJobName(c.getStaff().getStafJob().getName());
            result.setJobTitleID(c.getStaff().getStafJob().getJobTitleID());
            result.setProfileCategoryID(c.getStaff().getStafJob().getProfileCategory().getProfileCategoryID());
            result.setProfileName(c.getStaff().getStafJob().getProfileCategory().getName());
            result.setFonction(c.getStaff().getFonction());
            result.setServadmin(c.getStaff().getServices().isAdmin());
            result.setOrgAdmin(c.getStaff().getServices().getOrganization().isAdmin());
        }

        return result;
    }

    @Override
    public void logout(long id) {
        User user = usrDao.findUserByID(id);
        user.setConnect(false);
        user.setStatus("Hors ligne");
        usrDao.save(user);

    }

    @Override
    public List<UserInfo> getUserByRegion(long regionID) {
        List<Contact> us = ctnDao.finAllContactByRegion(regionID);
        List<UserInfo> result = new ArrayList<UserInfo>();
        for (Contact cts : us) {
            UserInfo inf = setuserInfo(cts);

            result.add(inf);
        }
        return result;
    }

    public UserInfo setuserInfo(Contact c) {
        UserInfo result = new UserInfo();
        // user info
        User usr = c.getUser();
        result.setUserID(usr.getId());
        result.setUserName(usr.getUsername());
        List<Role> r = usr.getRoles();
        List<RoleInfo> role = new ArrayList<RoleInfo>();
        for (Role rr : r) {
            RoleInfo ri = new RoleInfo();
            ri.setRoleID(rr.getId());
            ri.setName(rr.getName());
            role.add(ri);
        }
        result.setRoles(role);
        // contact info
        result.setContactID(c.getContactID());
        result.setAge(c.getAge());
        result.setNom(c.getNom());
        result.setPrenom(c.getPrenom());
        result.setSexe(c.getSex());
        result.setEmail(c.getEmail());
        result.setPhoneNumber(c.getPhoneNumber());
        result.setContactID(c.getContactID());
        result.setCityID(c.getCityContact().getCityID());
        result.setCityName(c.getCityContact().getName());
        result.setCountryID(c.getCityContact().getCityRegion().getCoutryRegion().getCountryID());
        result.setRegionID(c.getCityContact().getCityRegion().getRegionID());
        result.setRegionName(c.getCityContact().getCityRegion().getName());
        result.setCountryName(c.getCityContact().getCityRegion().getCoutryRegion().getNomFr());
        //// doctor info
        if (c.getDoctors() != null) {
            result.setDctID(c.getDoctors().getDoctorID());
            result.setFonction(c.getDoctors().getFonction());
            result.setNotifID(c.getDoctors().getNotifID());
            result.setOrgID(c.getDoctors().getServices().getOrganization().getOrgID());
            result.setOrgName(c.getDoctors().getServices().getOrganization().getOrgName());
            result.setSrvID(c.getDoctors().getServices().getSrvID());
            result.setSrvName(c.getDoctors().getServices().getServicesName());
            result.setJobName(c.getDoctors().getDctJob().getName());
            result.setJobTitleID(c.getDoctors().getDctJob().getJobTitleID());
            result.setProfileCategoryID(c.getDoctors().getDctJob().getProfileCategory().getProfileCategoryID());
            result.setProfileName(c.getDoctors().getDctJob().getProfileCategory().getName());
            result.setFonction(c.getDoctors().getFonction());
            result.setServadmin(c.getDoctors().getServices().isAdmin());
            result.setOrgAdmin(c.getDoctors().getServices().getOrganization().isAdmin());
        }
        // staff info
        if (c.getStaff() != null) {
            result.setStaffID(c.getStaff().getStaffID());
            result.setNotifID(c.getStaff().getNotifID());
            result.setOrgID(c.getStaff().getServices().getOrganization().getOrgID());
            result.setOrgName(c.getStaff().getServices().getOrganization().getOrgName());
            result.setSrvID(c.getStaff().getServices().getSrvID());
            result.setSrvName(c.getStaff().getServices().getServicesName());
            result.setJobName(c.getStaff().getStafJob().getName());
            result.setJobTitleID(c.getStaff().getStafJob().getJobTitleID());
            result.setProfileCategoryID(c.getStaff().getStafJob().getProfileCategory().getProfileCategoryID());
            result.setProfileName(c.getStaff().getStafJob().getProfileCategory().getName());
            result.setFonction(c.getStaff().getFonction());
            result.setServadmin(c.getStaff().getServices().isAdmin());
            result.setOrgAdmin(c.getStaff().getServices().getOrganization().isAdmin());
        }

        return result;
    }

    @Override
    public List<UserInfo> getDctUserByOrg(long orgID) {
        List<User> us = usrDao.finAllDctUserByOrg(orgID);
        List<UserInfo> result = new ArrayList<UserInfo>();
        for (User cts : us) {
            UserInfo inf = setuserInfo(cts.getContact());

            result.add(inf);
        }
        return result;
    }

    @Override
    public List<UserInfo> getStaffUserByOrg(long orgID) {
        List<User> us = usrDao.finAllStaffUserByOrg(orgID);
        List<UserInfo> result = new ArrayList<UserInfo>();
        for (User cts : us) {
            UserInfo inf = setuserInfo(cts.getContact());

            result.add(inf);
        }
        return result;
    }

    @Override
    public boolean checkUserName(String username) {
        return usrDao.existsUserName(username);
    }

    @Override
    public void addUserOrupdate(UserBody data) {
        if (data.getUserID() == 0) {

            Contact c = new Contact();
            User u = new User();
            Services srv = srvDao.findServicesID(data.getSrvID());
            JobTitle j = jbDao.findJobByID(data.getFonction());
            u.setEnabled(true);
            u.setActive("1");
            u.setConnect(true);
            u.setAccountNonExpired(false);
            u.setAccountNonLocked(false);
            u.setCredentialsNonExpired(false);
            u.setStatus("Hors ligne");
            u.setEmail(data.getEmail());
            u.setUsername(data.getUsername());
            u.setPassword(passwordEncoders(data.getPassword()));
            usrDao.save(u);
            // add role
            setRole(u, data.getFonction());
            c.setCityContact(srv.getOrganization().getCity());
            c.setNom(data.getNom());
            c.setPrenom(data.getPrenom());
            c.setSex(data.getSexe());
            c.setUser(u);
            c.setEmail(data.getEmail());
            ctnDao.save(c);
            if (data.getType().equals("Staff")) {
                Staff stf = new Staff();

                stf.setContact(c);
                stf.setServices(srv);
                stf.setStafJob(j);
                stf.setNotifID(uuidGenerator());
                stfDao.save(stf);
                c.setStaff(stf);
                ctnDao.save(c);
            }
            if (data.getType().equals("Doctor")) {
                Doctors dct = new Doctors();
                dct.setContact(c);
                dct.setDctJob(j);
                dct.setFonction(j.getName());
                dct.setNotifID(uuidGenerator());
                dct.setServices(srv);
                dctDao.save(dct);
                c.setDoctors(dct);
                ctnDao.save(c);
            }

        } else {
             new Contact();
            User u = usrDao.findUserByID(data.getUserID());
            Contact c =u.getContact();
            Services srv = srvDao.findServicesID(data.getSrvID());
            JobTitle j = jbDao.findJobByID(data.getFonction());
            u.setEmail(data.getEmail());
            u.setUsername(data.getUsername());
            usrDao.save(u);
            if(!u.getRoles().isEmpty()) {
                 List<Role> usrRole=u.getRoles();
                 for(int i=0;i<usrRole.size();i++) {
                        Role r = usrRole.get(i);
                        usrDao.deleteRole(r.getId(),u.getId());
                    }
               }
            setRole(u, data.getFonction());
            c.setCityContact(srv.getOrganization().getCity());
            c.setNom(data.getNom());
            c.setPrenom(data.getPrenom());
            c.setSex(data.getSexe());
            c.setEmail(data.getEmail());
            ctnDao.save(c);
            if (data.getType().equals("Staff")) {
                Staff stf =c.getStaff();
                stf.setServices(srv);
                stf.setStafJob(j);
                stfDao.save(stf);
                c.setStaff(stf);
                ctnDao.save(c);
            }
            if (data.getType().equals("Doctor")) {
                Doctors dct =c.getDoctors();
                dct.setDctJob(j);
                dct.setFonction(j.getName());
                dct.setServices(srv);
                dctDao.save(dct);
                c.setDoctors(dct);
                ctnDao.save(c);
            }


        }

    }

    public static String uuidGenerator() {

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        return randomUUIDString;
    }

    public void setRole(User u, long id) {
        if (id == 100) {
            String roleName = "PubOrg";
            Role r = roleDao.getRoleByName(roleName);
            u.setRole(r);
            usrDao.save(u);
        } else if (id == 1 || id == 3) {
            String roleName = "PubSrv";
            Role r = roleDao.getRoleByName(roleName);
            u.setRole(r);
            usrDao.save(u);
        } else {
            String roleName = "Subscriber";
            Role r = roleDao.getRoleByName(roleName);
            u.setRole(r);
            usrDao.save(u);
        }

    }

    public String passwordEncoders(String pwd) {
        String encodedPwd = "";
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        encodedPwd = encoder.encode(pwd);
        return encodedPwd;

    }
}
