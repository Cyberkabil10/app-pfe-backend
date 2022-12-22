package com.allodoc.tn.covibed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allodoc.tn.covibed.Utils.ScheduledFunction;
import com.allodoc.tn.covibed.model.Contact;
import com.allodoc.tn.covibed.services.IBedService;
import com.allodoc.tn.covibed.services.IContactservice;
import com.allodoc.tn.covibed.services.IDoctorsService;
import com.allodoc.tn.covibed.services.IJobTitleServices;
import com.allodoc.tn.covibed.services.ILicenseServices;
import com.allodoc.tn.covibed.services.IOrganizationService;
import com.allodoc.tn.covibed.services.IRoleService;
import com.allodoc.tn.covibed.services.IServicesService;
import com.allodoc.tn.covibed.services.ITempBedService;
import com.allodoc.tn.covibed.services.IUserService;
import com.allodoc.tn.covibed.tools.BedInfo;
import com.allodoc.tn.covibed.tools.BedStatInfo;
import com.allodoc.tn.covibed.tools.JobInfo;
import com.allodoc.tn.covibed.tools.LicenseInfo;
import com.allodoc.tn.covibed.tools.OrgBody;
import com.allodoc.tn.covibed.tools.RoleInfo;
import com.allodoc.tn.covibed.tools.ServicesBody;
import com.allodoc.tn.covibed.tools.UserBody;
import com.allodoc.tn.covibed.tools.UserInfo;

@CrossOrigin("*")
@RequestMapping("api/")
@RestController
public class MainController {

    @Autowired
    IDoctorsService dctSrv;
    @Autowired
    IOrganizationService orgSrv;
    @Autowired
    IServicesService serviceSrv;
    @Autowired
    IBedService bedSrv;
    @Autowired
    IUserService usrSrv;
    @Autowired
    ITempBedService tmpBedSrv;
    @Autowired
    IContactservice cntSrv;
    @Autowired
    IJobTitleServices jobSrv;
    @Autowired
    IRoleService rlSrv;
    @Autowired
    ILicenseServices lsSrv;
    @Autowired
    ScheduledFunction test;






    @GetMapping("getBedStatInfoByCountry/{countryId}")
    public List<BedStatInfo> getBedStatInfoByCountry(@PathVariable(name = "countryId") long countryId) {

        return bedSrv.getBedStatInfoByCountry(countryId);
    }

    @GetMapping("getCountryBedStatInfo/{countryId}")
    public BedStatInfo getCountryBedStatInfo(@PathVariable(name = "countryId") long countryId) {
        return bedSrv.getCountryBedStatInfo(countryId);
    }

    @GetMapping("getBedStatInfoByRegion/{regionId}")
    public List<BedStatInfo> getBedStatInfoByRegion(@PathVariable(name = "regionId") long regionId) {
        return bedSrv.getBedStatInfoByRegion(regionId);
    }

    @GetMapping("getRegionBedStatInfo/{regionId}")
    public BedStatInfo getRegionBedStatInfo(@PathVariable(name = "regionId") long regionId) {

        return bedSrv.getRegionBedStatInfo(regionId);
    }

    @GetMapping("getBedStatInfoByCity/{cityID}")
    public List<BedStatInfo> getBedStatInfoByCity(@PathVariable(name = "cityID") long cityID) {
        return bedSrv.getBedStatInfoByCity(cityID);
    }

    @GetMapping("getCityBedStatInfo/{cityID}")
    public BedStatInfo getCityBedStatInfo(@PathVariable(name = "cityID") long cityID) {

        return bedSrv.getCityBedStatInfo(cityID);
    }

    @GetMapping("getBedStatInfoByOrg/{orgId}")
    public List<BedStatInfo> getBedStatInfoByOrg(@PathVariable(name = "orgId") long orgId) {

        return bedSrv.getBedStatInfoByOrg(orgId);
    }

    @GetMapping("getOrgBedStatInfo/{orgId}")
    public BedStatInfo getOrgBedStatInfo(@PathVariable(name = "orgId") long orgId) {

        return bedSrv.getOrgBedStatInfo(orgId);
        //return bedSrv.getBedStatInfoByOrg(orgId);
    }

    @GetMapping("getBedInfoDetailsByOrg/{orgId}")
    public List<BedStatInfo> getBedInfoDetailsByOrg(@PathVariable(name = "orgId") long orgId) {
        return bedSrv.getBedInfoDetailsByOrg(orgId);
    }

    @GetMapping("getBedInfoDetailsBySvc/{srvId}")
    public BedStatInfo getBedInfoDetailsBySvc(@PathVariable(name = "srvId") long srvId) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return bedSrv.getBedInfoDetailsBySvc(srvId);
    }

    @GetMapping("getBedRegionOrganization/{regionId}")
    public List<BedStatInfo> getBedRegionOrganization(@PathVariable(name = "regionId") long regionId) {
        return bedSrv.getBedRegionOrganization(regionId);
    }

    @GetMapping("getBedInfoByID/{bedID}")
    public BedInfo getBedInfoById(@PathVariable(name = "bedID") long bedID) {
        return bedSrv.getBedInfoById(bedID);
    }

     ////:user info
    @GetMapping("getUserInfo/{userName}")
    public UserInfo getUserInfo(@PathVariable(name = "userName") String userName) {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return usrSrv.getUserInfo(userName);
    }

    /// Organization && services
    @GetMapping("getAllOrganization")
    public List<OrgBody> getAllOrganization() {
        return orgSrv.getAllOrganization();
    }

    @PostMapping("/addOrUpdateOrganization")
    public Object addOrUpdateOrg(@RequestBody OrgBody org) {

        return orgSrv.addOrUpdateOrg(org);

    }
    @GetMapping("getOrganizationServices/{orgID}")
    public List<ServicesBody> getOrganizationServices(@PathVariable(name = "orgID") long orgID) {
        return serviceSrv.getOrganizationServices(orgID);
    }
    @PostMapping("/addOrUpdateService")
    public Object addOrUpdateService(@RequestBody ServicesBody data) {

        return serviceSrv.addOrUpdateService(data);

    }
    @PostMapping("/addOrUpdateBed")
    public Object addOrUpdateBed(@RequestBody BedInfo data) {
   if(data.getType()!=null && data.getType().contentEquals("tmp")) {
       System.out.println("update tmp bed");
       return tmpBedSrv.addOrUpdateTmpBed(data);

   }else{
       return bedSrv.addOrUpdateBed(data);
   }


    }

    @PostMapping("logoutUser")
    public void logout(@RequestBody long id) {

        usrSrv.logout(id);

    }
    @GetMapping("getNewtmpBedAvailbal")
    public BedInfo getNewtmpBedAvailbal() {
        return tmpBedSrv.getNewtmpBedAvailbal();
    }
    @PostMapping("tieUpTmpBedToSrv")
    public BedInfo tieUptmpBedToSrv(@RequestBody long srvID) {

        return tmpBedSrv.tieUptmpBedToSrv(srvID);

    }
    @PostMapping("releaseTmpBed")
    public BedInfo releaseTmpBed(@RequestBody long tmpBedID) {

        return tmpBedSrv.releaseTmpBed(tmpBedID);

    }
    @GetMapping("getUserByRegion/{regionID}")
    public List<UserInfo> getuserByRegion(@PathVariable(name = "regionID") long regionID) {
        return usrSrv.getUserByRegion(regionID);
    }
    @GetMapping("getOrganizationByRegion/{regionId}")
    public List<OrgBody> getorganizationByRegion(@PathVariable(name = "regionId") long regionId) {
        return orgSrv.getorganizationByRegion(regionId);
    }
    @GetMapping("getDctUserByOrg/{orgID}")
    public List<UserInfo> getDctUserByOrg(@PathVariable(name = "orgID") long orgID) {
        return usrSrv.getDctUserByOrg(orgID);
    }
    @GetMapping("getStaffUserByOrg/{orgID}")
    public List<UserInfo> getStaffUserByOrg(@PathVariable(name = "orgID") long orgID) {
        return usrSrv.getStaffUserByOrg(orgID);
    }
    @DeleteMapping("deleteContact/{contactID}")
    public void deleteContact(@PathVariable(name = "contactID") long contactID) {
        cntSrv.deleteContact(contactID);

    }
    @GetMapping("getAllJob")
    public List<JobInfo> getAllJob() {
        return jobSrv.getAllJob();
    }
    @GetMapping("getAllRole")
    public List<RoleInfo> getAllRole() {
        return rlSrv.getAllRole();
    }
    @GetMapping("checkUserName/{username}")
    public boolean checkUserName(@PathVariable(name = "username") String username) {
        return usrSrv.checkUserName(username);
    }
    @PostMapping("addUserOrUpdate")
    public void addUserOrupdate(@RequestBody UserBody data) {

         usrSrv.addUserOrupdate(data);

    }
    @GetMapping("getServicesList/{orgID}")
    public List<ServicesBody> getServicesList(@PathVariable(name = "orgID") long orgID) {
        return serviceSrv.getServicesList(orgID);
    }
    @GetMapping("getLicenseInfoByRegion/{regionID}")
    public LicenseInfo getLicenseByRegion(@PathVariable(name = "regionID") long regionID) {
        return lsSrv.getLicenseByRegion(regionID);
    }
//    @RequestMapping(value = "sendEmail", method = RequestMethod.GET)
//    public void sendEmail(Model model) throws Exception {
//
//         test.updatePAssword(model);
//
//    }
}
