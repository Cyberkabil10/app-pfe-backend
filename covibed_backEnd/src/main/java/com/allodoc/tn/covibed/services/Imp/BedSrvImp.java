package com.allodoc.tn.covibed.services.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IBedDao;
import com.allodoc.tn.covibed.dao.ICityDao;
import com.allodoc.tn.covibed.dao.ICountryDao;
import com.allodoc.tn.covibed.dao.IOrganizationDao;
import com.allodoc.tn.covibed.dao.IRegionDao;
import com.allodoc.tn.covibed.dao.IServicesDao;
import com.allodoc.tn.covibed.dao.ITempBedDao;
import com.allodoc.tn.covibed.model.Bed;
import com.allodoc.tn.covibed.model.City;
import com.allodoc.tn.covibed.model.Country;
import com.allodoc.tn.covibed.model.Organization;
import com.allodoc.tn.covibed.model.Region;
import com.allodoc.tn.covibed.model.Services;
import com.allodoc.tn.covibed.model.TempBed;
import com.allodoc.tn.covibed.services.IBedService;
import com.allodoc.tn.covibed.services.IServicesService;
import com.allodoc.tn.covibed.tools.BedInfo;
import com.allodoc.tn.covibed.tools.BedStatInfo;


@Service
public class BedSrvImp implements IBedService {
    @Autowired
    IRegionDao regDao;
    @Autowired
    ICityDao cityDao;
    @Autowired
    IBedDao bedDao;
    @Autowired
    IOrganizationDao orgDao;
    @Autowired
    IServicesDao srvcDao;
    @Autowired
    ICountryDao cntDoa;
    @Autowired
    ITempBedDao tmpBedDao;


    @Override
    public List<BedStatInfo> getBedStatInfoByCountry(long countryId) {
        List<BedStatInfo> result = new ArrayList<BedStatInfo>();
        //List<Region> regions = regDao.findAllRegionByContryID(countryId);
        List<Region> regions = regDao.findAllRegionWithOrgByContryID(countryId);

        if (regions != null && !regions.isEmpty()) {
            for (Region r : regions) {
                BedStatInfo info = new BedStatInfo();
                info.setCountryID(countryId);
                info.setCountryName(r.getCoutryRegion().getNomFr());
                info.setRegionID(r.getRegionID());
                info.setRegionName(r.getName());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                BedInfo bed = new BedInfo();
                int totalO2 = 0;
                int totalTmpBedO2 = 0;
                int totalBed = bedDao.totalBedCountByRegion(r.getRegionID());
                int totalBedAvailbal = bedDao.totalBedAvailbalByRegion(r.getRegionID());
                int totalBedintubation = bedDao.totalIntubationByRegion(r.getRegionID());
                int totalMinor = bedDao.totalMinorByRegion(r.getRegionID());
                int totalMajor = bedDao.totalMajorByRegion(r.getRegionID());
                int totalCritical = bedDao.totaCriticalByRegion(r.getRegionID());
                if (totalBed > 0  && totalBed!=totalBedAvailbal) {
                    totalO2 = bedDao.totalO2ByRegion(r.getRegionID());
                }
                /////////add bed tmp stat

                int totalTmpBed = tmpBedDao.totalTmpBedCountByRegion(r.getRegionID());
                int totalTmBedAvailbal = tmpBedDao.totalTmpBedAvailbalByRegion(r.getRegionID());
                int totalTmBedintubation = tmpBedDao.totalTmpIntubationByRegion(r.getRegionID());
                int totalTmMinor = tmpBedDao.totalTmpMinorByRegion(r.getRegionID());
                int totalTmMajor = tmpBedDao.totalTmpMajorByRegion(r.getRegionID());
                int totalTmCritical = tmpBedDao.totalTmpCriticalByRegion(r.getRegionID());
                if (totalTmpBed > 0  &&totalTmpBed!=totalTmBedAvailbal) {
                    totalTmpBedO2 = tmpBedDao.totalTmpO2ByRegion(r.getRegionID());
                }








                ////////////////////
                bed.setTotalBeds(totalBed+totalTmpBed);
                bed.setTotalavailbal(totalBedAvailbal+totalTmBedAvailbal);
                bed.setTotalIntubation(totalBedintubation+totalTmBedintubation);
                bed.setMinor(totalMinor+totalTmMinor);
                bed.setMajor(totalMajor+totalTmMajor);
                bed.setCritical(totalCritical+totalTmCritical);
                bed.setO2(totalO2+totalTmpBedO2);

                beds.add(bed);
                info.setBed(beds);
                result.add(info);

            }

        }

        return result;
    }
    @Override
    public List<BedStatInfo> getBedStatInfoByRegion(long regionId) {
        List<BedStatInfo> result = new ArrayList<BedStatInfo>();
        //List<City> citys = cityDao.findAllCityByReionID(regionId);
        List<City> citys = cityDao.getAllCitiesWithOrgByRegionID(regionId);
        if (citys != null && !citys.isEmpty()) {
            for (City c : citys) {
                BedStatInfo info = new BedStatInfo();
                info.setCountryID(c.getCityRegion().getCoutryRegion().getCountryID());
                info.setCountryName(c.getCityRegion().getCoutryRegion().getNomFr());
                info.setRegionID(c.getCityRegion().getRegionID());
                info.setRegionName(c.getCityRegion().getName());
                info.setCityID(c.getCityID());
                info.setCityName(c.getName());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                BedInfo bed = new BedInfo();
                int totalO2 = 0;
                int totalTmpBedO2 = 0;
                int totalBed = bedDao.totalBedCountByCity(c.getCityID());
                int totalBedAvailbal = bedDao.totalBedAvailbalByCity(c.getCityID());
                int totalBedintubation = bedDao.totalIntubationByCity(c.getCityID());
                int totalMinor = bedDao.totalMinorByCity(c.getCityID());
                int totalMajor = bedDao.totalMajorByCity(c.getCityID());
                int totalCritical = bedDao.totaCriticalByCity(c.getCityID());
                if (totalBed > 0  && totalBed!=totalBedAvailbal) {
                    totalO2 = bedDao.totalO2ByCity(c.getCityID());
                }
                /////////////stat tmp

                int totalTmpBed = tmpBedDao.totalTmpBedCountByCity(c.getCityID());
                int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalByCity(c.getCityID());
                int totalTmpBedintubation = tmpBedDao.totalTmpIntubationByCity(c.getCityID());
                int totalTmpMinor = tmpBedDao.totalTmpMinorByCity(c.getCityID());
                int totalTmpMajor = tmpBedDao.totalTmpMajorByCity(c.getCityID());
                int totalTmpCritical = tmpBedDao.totalTmpCriticalByCity(c.getCityID());
                if (totalTmpBed > 0  && totalTmpBed!=totalTmpBedAvailbal) {
                    totalTmpBedO2 = tmpBedDao.totalTmpO2ByCity(c.getCityID());
                }





                /////////////
                bed.setTotalBeds(totalBed+totalTmpBed);
                bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
                bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
                bed.setMinor(totalMinor+totalTmpMinor);
                bed.setMajor(totalMajor+totalTmpMajor);
                bed.setCritical(totalCritical+totalTmpCritical);
                bed.setO2(totalO2+totalTmpBedO2);

                beds.add(bed);
                info.setBed(beds);
                result.add(info);

            }

        }

        return result;
    }

    @Override
    public List<BedStatInfo> getBedStatInfoByCity(long cityID) {
        List<BedStatInfo> result = new ArrayList<BedStatInfo>();
        List<Organization> orgs = orgDao.findAllOrganisationBYCityID(cityID);
        if (orgs != null && !orgs.isEmpty()) {
            for (Organization org : orgs) {
                BedStatInfo info = new BedStatInfo();
                info.setCountryID(org.getCity().getCityRegion().getCoutryRegion().getCountryID());
                info.setCountryName(org.getCity().getCityRegion().getCoutryRegion().getNomFr());
                info.setRegionID(org.getCity().getCityRegion().getRegionID());
                info.setRegionName(org.getCity().getCityRegion().getName());
                info.setCityID(cityID);
                info.setCityName(org.getCity().getName());
                info.setOrgID(org.getOrgID());
                info.setOrgName(org.getOrgName());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                BedInfo bed = new BedInfo();
                int totalO2 = 0;
                int totalTmpO2=0;
                int totalBed = bedDao.totalBedCountByOrg(org.getOrgID());
                int totalBedAvailbal = bedDao.totalBedAvailbalByOrg(org.getOrgID());
                int totalBedintubation = bedDao.totalIntubationByOrg(org.getOrgID());
                int totalMinor = bedDao.totalMinorByOrg(org.getOrgID());
                int totalMajor = bedDao.totalMajorByOrg(org.getOrgID());
                int totalCritical = bedDao.totaCriticalByOrg(org.getOrgID());
                if (totalBed > 0 && totalBed!=totalBedAvailbal) {
                    totalO2 = bedDao.totalO2ByOrg(org.getOrgID());
                }
                int totalTmpBed = tmpBedDao.totalTmpBedCountByOrg(org.getOrgID());
                int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalByOrg(org.getOrgID());
                int totalTmpBedintubation = tmpBedDao.totalTmpIntubationByOrg(org.getOrgID());
                int totalTmpMinor = tmpBedDao.totalTmpMinorByOrg(org.getOrgID());
                int totalTmpMajor = tmpBedDao.totalTmpMajorByOrg(org.getOrgID());
                int totalTmpCritical = tmpBedDao.totalTmpCriticalByOrg(org.getOrgID());
                if (totalTmpBed > 0  && totalTmpBed!=totalTmpBedAvailbal) {
                    totalTmpO2 = tmpBedDao.totalTmpO2ByOrg(org.getOrgID());
                }





                bed.setTotalBeds(totalBed+totalTmpBed);
                bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
                bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
                bed.setMinor(totalMinor+totalTmpMinor);
                bed.setMajor(totalMajor+totalTmpMajor);
                bed.setCritical(totalCritical+totalTmpCritical);
                bed.setO2(totalO2+totalTmpO2);

                beds.add(bed);
                info.setBed(beds);
                result.add(info);

            }
        }

        return result;
    }
    @Override
    public List<BedStatInfo> getBedStatInfoByOrg(long orgId) {
        List<BedStatInfo> result = new ArrayList<BedStatInfo>();
        List<Services> servs = srvcDao.findAllServicesByOrgID(orgId);
        if (servs != null && !servs.isEmpty()) {
            for (Services srv : servs) {
                BedStatInfo info = new BedStatInfo();
                info.setCountryID(srv.getOrganization().getCity().getCityRegion().getCoutryRegion().getCountryID());
                info.setCountryName(srv.getOrganization().getCity().getCityRegion().getCoutryRegion().getNomFr());
                info.setRegionID(srv.getOrganization().getCity().getCityRegion().getRegionID());
                info.setRegionName(srv.getOrganization().getCity().getCityRegion().getName());
                info.setCityID(srv.getOrganization().getCity().getCityID());
                info.setCityName(srv.getOrganization().getCity().getName());
                info.setOrgID(srv.getOrganization().getOrgID());
                info.setType(srv.getOrganization().getType());
                info.setOrgName(srv.getOrganization().getOrgName());
                info.setSvcID(srv.getSrvID());
                info.setSvcName(srv.getServicesName());
                info.setSrvImg(srv.getImgurl());
                info.setOrgID(srv.getOrganization().getOrgID());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                BedInfo bed = new BedInfo();
                int totalO2 = 0;
                int totalTmpBedO2 = 0;
                int totalBed = bedDao.totalBedCountBySrv(srv.getSrvID());
                int totalBedAvailbal = bedDao.totalBedAvailbalBySrv(srv.getSrvID());
                int totalBedintubation = bedDao.totalIntubationBySrv(srv.getSrvID());
                int totalMinor = bedDao.totalMinorBySrv(srv.getSrvID());
                int totalMajor = bedDao.totalMajorBySrv(srv.getSrvID());
                int totalCritical = bedDao.totaCriticalBySrv(srv.getSrvID());
                if (totalBed > 0 && totalBed!=totalBedAvailbal) {
                    totalO2 = bedDao.totalO2BySrv(srv.getSrvID());
                }
                ///add temp bed stat
                int totalTmpBed = tmpBedDao.totalTmpBedCountBySrv(srv.getSrvID());
                int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalBySrv(srv.getSrvID());
                int totalTmpBedintubation = tmpBedDao.totalTmpIntubationBySrv(srv.getSrvID());
                int totalTmpMinor = tmpBedDao.totalTmpMinorBySrv(srv.getSrvID());
                int totalTmpMajor = tmpBedDao.totalTmpMajorBySrv(srv.getSrvID());
                int totalTmpCritical = tmpBedDao.totalTmpCriticalBySrv(srv.getSrvID());
                if (totalTmpBed > 0 && totalTmpBed!=totalTmpBedAvailbal) {
                    totalTmpBedO2 = tmpBedDao.totalTmpO2BySrv(srv.getSrvID());
                }

                /////

                bed.setTotalBeds(totalBed+totalTmpBed);
                bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
                bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
                bed.setMinor(totalMinor+totalTmpMinor);
                bed.setMajor(totalMajor+totalTmpMajor);
                bed.setCritical(totalCritical+totalTmpCritical);
                bed.setO2(totalO2+totalTmpBedO2);

                beds.add(bed);
                info.setBed(beds);
                result.add(info);

            }
        }

        return result;
    }
    @Override
    public List<BedStatInfo> getBedInfoDetailsByOrg(long orgId) {

        List<BedStatInfo> result = new ArrayList<BedStatInfo>();
        List<Services> servs = srvcDao.findAllServicesByOrgID(orgId);
        if (servs != null && !servs.isEmpty()) {
            for (Services srv : servs) {
                BedStatInfo info = new BedStatInfo();
                info.setCountryID(srv.getOrganization().getCity().getCityRegion().getCoutryRegion().getCountryID());
                info.setCountryName(srv.getOrganization().getCity().getCityRegion().getCoutryRegion().getNomFr());
                info.setRegionID(srv.getOrganization().getCity().getCityRegion().getRegionID());
                info.setRegionName(srv.getOrganization().getCity().getCityRegion().getName());
                info.setCityID(srv.getOrganization().getCity().getCityID());
                info.setCityName(srv.getOrganization().getCity().getName());
                info.setOrgID(srv.getOrganization().getOrgID());
                info.setType(srv.getOrganization().getType());
                info.setOrgName(srv.getOrganization().getOrgName());
                info.setSvcID(srv.getSrvID());
                info.setOrgID(srv.getOrganization().getOrgID());
                info.setSvcName(srv.getServicesName());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                 for(Bed b:srv.getBed()) {

                     BedInfo bdInfo= getbedDetailInfo(b);
                     beds.add(bdInfo);
                 }

                info.setBed(beds);
                result.add(info);
            }
        }

        return result;
    }

   @Override
   public BedStatInfo getBedInfoDetailsBySvc(long srvId) {
       BedStatInfo info = new BedStatInfo();
        Services srv = srvcDao.findServicesID(srvId);
        info.setCountryID(srv.getOrganization().getCity().getCityRegion().getCoutryRegion().getCountryID());
        info.setCountryName(srv.getOrganization().getCity().getCityRegion().getCoutryRegion().getNomFr());
        info.setRegionID(srv.getOrganization().getCity().getCityRegion().getRegionID());
        info.setRegionName(srv.getOrganization().getCity().getCityRegion().getName());
        info.setCityID(srv.getOrganization().getCity().getCityID());
        info.setCityName(srv.getOrganization().getCity().getName());
        info.setOrgID(srv.getOrganization().getOrgID());
        info.setType(srv.getOrganization().getType());
        info.setOrgName(srv.getOrganization().getOrgName());
        info.setType(srv.getOrganization().getType());
        info.setSvcID(srv.getSrvID());
        info.setSvcName(srv.getServicesName());
        info.setOrgID(srv.getOrganization().getOrgID());
        List<BedInfo> beds = new ArrayList<BedInfo>();
        List<BedInfo> tmpBeds = new ArrayList<BedInfo>();
         for(Bed b:srv.getBed()) {

             BedInfo bdInfo= getbedDetailInfo(b);
             beds.add(bdInfo);
         }
         List<TempBed> tmpbeds=tmpBedDao.findAllTmpBedBysrvID(srvId);
     for(TempBed b:tmpbeds) {

             BedInfo bdInfo= getTmpbedDetailInfo(b);
             tmpBeds.add(bdInfo);
         }

         info.setTmpbed(tmpBeds);
         info.setBed(beds);
    return info;
}
   public BedInfo getbedDetailInfo(Bed bed) {
    BedInfo b = new BedInfo();
    b.setBedID(bed.getBedID());
    b.setLabel(bed.getLabel());
    b.setAvailability(bed.isAvailability());
    b.setGravity(bed.getGravity());
    b.setIntubation(bed.isIntubation());
    b.setO2(bed.getO2());
    b.setOrgName(bed.getServices().getOrganization().getOrgName());
    b.setSvcName(bed.getServices().getServicesName());
    b.setSrvcID(bed.getServices().getSrvID());
    b.setOrgID(bed.getServices().getOrganization().getOrgID());
    if(bed.getQrCode()!=null) {

        b.setQrCode(bed.getQrCode().getUrl());
    }


    return b;
}
   public BedInfo getTmpbedDetailInfo(TempBed bed) {
        BedInfo b = new BedInfo();
        b.setBedID(bed.getTempBedID());
        b.setLabel(bed.getLabel());
        b.setAvailability(bed.isAvailability());
        b.setGravity(bed.getGravity());
        b.setIntubation(bed.isIntubation());
        b.setO2(bed.getO2());
        b.setType(bed.getType());
        if (bed.getServices() != null) {
            b.setOrgName(bed.getServices().getOrganization().getOrgName());
            b.setSvcName(bed.getServices().getServicesName());
            b.setSrvcID(bed.getServices().getSrvID());
            b.setOrgID(bed.getServices().getOrganization().getOrgID());
        }



        return b;
    }
    @Override
    public BedStatInfo getRegionBedStatInfo(long regionId) {
        // TODO Auto-generated method stub
        BedStatInfo info = new BedStatInfo();
        Region region=this.regDao.getRegionById(regionId);
        info.setCountryID(region.getCoutryRegion().getCountryID());
        info.setCountryName(region.getCoutryRegion().getNomFr());
        info.setRegionID(region.getRegionID());
        info.setRegionName(region.getName());

        List<BedInfo> beds = new ArrayList<BedInfo>();
        BedInfo bed = new BedInfo();
        int totalO2 = 0;
        int totalTmpBedO2 = 0;
        int totalBed = bedDao.totalBedCountByRegion(region.getRegionID());
        int totalBedAvailbal = bedDao.totalBedAvailbalByRegion(region.getRegionID());
        int totalBedintubation = bedDao.totalIntubationByRegion(region.getRegionID());
        int totalMinor = bedDao.totalMinorByRegion(region.getRegionID());
        int totalMajor = bedDao.totalMajorByRegion(region.getRegionID());
        int totalCritical = bedDao.totaCriticalByRegion(region.getRegionID());
        if (totalBed > 0  && totalBed!=totalBedAvailbal) {
            totalO2 = bedDao.totalO2ByRegion(region.getRegionID());
        }
        //add temp bed stat

        int totalTmpBed = tmpBedDao.totalTmpBedCountByRegion(region.getRegionID());
        int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalByRegion(region.getRegionID());
        int totalTmpBedintubation = tmpBedDao.totalTmpIntubationByRegion(region.getRegionID());
        int totalTmpMinor = tmpBedDao.totalTmpMinorByRegion(region.getRegionID());
        int totalTmpMajor = tmpBedDao.totalTmpMajorByRegion(region.getRegionID());
        int totalTmpCritical = tmpBedDao.totalTmpCriticalByRegion(region.getRegionID());
        if (totalTmpBed > 0  && totalBed!=totalBedAvailbal) {
            totalTmpBedO2 = tmpBedDao.totalTmpO2ByRegion(region.getRegionID());
        }

        /////////

        bed.setTotalBeds(totalBed+totalTmpBed);
        bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
        bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
        bed.setMinor(totalMinor+totalTmpMinor);
        bed.setMajor(totalMajor+totalTmpMajor);
        bed.setCritical(totalCritical+totalTmpCritical);
        bed.setO2(totalO2+totalTmpBedO2);

        beds.add(bed);
        info.setBed(beds);
        return info;
    }
    @Override
    public BedStatInfo getCountryBedStatInfo(long countryId) {
        // TODO Auto-generated method stub
        BedStatInfo info = new BedStatInfo();
        Country cnt=this.cntDoa.getCountryById(countryId);
        info.setCountryID(cnt.getCountryID());
        info.setCountryName(cnt.getNomFr());
        //info.setRegionID(region.getRegionID());
        //info.setRegionName(region.getName());
        List<BedInfo> beds = new ArrayList<BedInfo>();
        BedInfo bed = new BedInfo();
        int totalO2 = 0;
        int totalTmpBedO2 = 0;
        int totalBed = bedDao.totalBedCountByCountry(countryId);
        int totalBedAvailbal = bedDao.totalBedAvailbalByCountry(countryId);
        int totalBedintubation = bedDao.totalIntubationByCountry(countryId);
        int totalMinor = bedDao.totalMinorByCountry(countryId);
        int totalMajor = bedDao.totalMajorByCountry(countryId);
        int totalCritical = bedDao.totaCriticalByCountry(countryId);
        if (totalBed > 0  && totalBed!=totalBedAvailbal) {
            totalO2 = bedDao.totalO2ByCountry(countryId);
        }
        /////// get tmp bed stat

        int totalTmpBed = tmpBedDao.totalTmpBedCountByCountry(countryId);
        int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalByCountry(countryId);
        int totalTmpBedintubation = tmpBedDao.totalTmpIntubationByCountry(countryId);
        int totalTmpMinor = tmpBedDao.totalTmpMinorByCountry(countryId);
        int totalTmpMajor = tmpBedDao.totalTmplMajorByCountry(countryId);
        int totalTmpCritical = tmpBedDao.totalTmpCriticalByCountry(countryId);
        if (totalTmpBed > 0  && totalTmpBed!=totalTmpBedAvailbal) {
            totalTmpBedO2 = tmpBedDao.totalTmpO2ByCountry(countryId);
        }






        //////////
        bed.setTotalBeds(totalBed+totalTmpBed);
        bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
        bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
        bed.setMinor(totalMinor+totalTmpMinor);
        bed.setMajor(totalMajor+totalTmpMajor);
        bed.setCritical(totalCritical+totalTmpCritical);
        bed.setO2(totalO2+totalTmpBedO2);

        beds.add(bed);
        info.setBed(beds);
        return info;
    }
    @Override
    public BedStatInfo getCityBedStatInfo(long cityId) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
                BedStatInfo info = new BedStatInfo();
                City cty=this.cityDao.getCityById(cityId);
                info.setCountryID(cty.getCityRegion().getCoutryRegion().getCountryID());
                info.setCountryName(cty.getCityRegion().getCoutryRegion().getNomFr());
                info.setRegionID(cty.getCityRegion().getRegionID());
                info.setRegionName(cty.getCityRegion().getName());
                info.setCityID(cty.getCityID());
                info.setCityName(cty.getName());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                BedInfo bed = new BedInfo();
                int totalO2 = 0;
                int totalBed = bedDao.totalBedCountByCity(cityId);
                int totalBedAvailbal = bedDao.totalBedAvailbalByCity(cityId);
                int totalBedintubation = bedDao.totalIntubationByCity(cityId);
                int totalMinor = bedDao.totalMinorByCity(cityId);
                int totalMajor = bedDao.totalMajorByCity(cityId);
                int totalCritical = bedDao.totaCriticalByCity(cityId);
                if (totalBed > 0  && totalBed!=totalBedAvailbal) {
                    totalO2 = bedDao.totalO2ByCity(cityId);
                }
                bed.setTotalBeds(totalBed);
                bed.setTotalavailbal(totalBedAvailbal);
                bed.setTotalIntubation(totalBedintubation);
                bed.setMinor(totalMinor);
                bed.setMajor(totalMajor);
                bed.setCritical(totalCritical);
                bed.setO2(totalO2);

                beds.add(bed);
                info.setBed(beds);
                return info;
    }
    @Override
    public BedStatInfo getOrganizationBedStatInfo(long orgId) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<BedStatInfo> getBedRegionOrganization(long regionID) {
        // TODO Auto-generated method stub
            BedStatInfo info = null;
            List<BedStatInfo> result = new ArrayList<BedStatInfo>();
            List <Organization> orgs=this.orgDao.findAllOrganisationByRegionID(regionID);
            if ( orgs != null && !orgs.isEmpty() ) {

                for (Organization org: orgs) {
                    info = new BedStatInfo();
                    info.setOrgID(org.getOrgID());
                    info.setOrgName(org.getOrgName());
                    info.setType(org.getType());
                    info.setOrgImg(org.getImgurl());
                    List<BedInfo> beds = new ArrayList<BedInfo>();
                    BedInfo bed = new BedInfo();
                    int totalO2 = 0;
                    int totalTmpO2 = 0;
                    int totalBed = bedDao.totalBedCountByOrg(org.getOrgID());
                    int totalBedAvailbal = bedDao.totalBedAvailbalByOrg(org.getOrgID());
                    int totalBedintubation = bedDao.totalIntubationByOrg(org.getOrgID());
                    int totalMinor = bedDao.totalMinorByOrg(org.getOrgID());
                    int totalMajor = bedDao.totalMajorByOrg(org.getOrgID());
                    int totalCritical = bedDao.totaCriticalByOrg(org.getOrgID());
                    if (totalBed > 0  && totalBed!=totalBedAvailbal) {
                        totalO2 = bedDao.totalO2ByOrg(org.getOrgID());
                    }
                    ///add tempo bed Stat


                    int totalTmpBed = tmpBedDao.totalTmpBedCountByOrg(org.getOrgID());
                    int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalByOrg(org.getOrgID());
                    int totalTmpBedintubation = tmpBedDao.totalTmpIntubationByOrg(org.getOrgID());
                    int totalTmpMinor = tmpBedDao.totalTmpMinorByOrg(org.getOrgID());
                    int totalTmpMajor = tmpBedDao.totalTmpMajorByOrg(org.getOrgID());
                    int totalTmpCritical = tmpBedDao.totalTmpCriticalByOrg(org.getOrgID());
                    if (totalTmpBed > 0  && totalTmpBed!=totalTmpBedAvailbal) {
                        totalTmpO2 = tmpBedDao.totalTmpO2ByOrg(org.getOrgID());
                    }






                    ///////
                    bed.setTotalBeds(totalBed+totalTmpBed);
                    bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
                    bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
                    bed.setMinor(totalMinor+totalTmpMinor);
                    bed.setMajor(totalMajor+totalTmpMajor);
                    bed.setCritical(totalCritical+totalTmpCritical);
                    bed.setO2(totalO2+totalTmpO2);
                    bed.setOrgID(org.getOrgID());
                    beds.add(bed);
                    info.setBed(beds);
                    result.add(info);

                }
            }



            return result;

    }
    @Override
    public BedInfo getBedInfoById(long bedID) {
        Bed b=bedDao.findBedInfoById(bedID);
        BedInfo result= new BedInfo();
        result.setSrvcID(b.getServices().getSrvID());
         result.setBedID(b.getBedID());
         result.setAvailability(b.isAvailability());
          result.setIntubation(b.isIntubation());
          result.setLabel(b.getLabel());
          result.setGravity(b.getGravity());
         result.setO2(b.getO2());
         result.setOrgID(b.getServices().getOrganization().getOrgID());
         result.setOrgName(b.getServices().getOrganization().getOrgName());
         result.setSvcName(b.getServices().getServicesName());
         if(b.getQrCode()!=null) {

                result.setQrCode(b.getQrCode().getUrl());
            }
        return result;
    }
    @Override
    public Object addOrUpdateBed(BedInfo data) {
    if(data.getBedID()!=0) {
        Bed b=bedDao.findBedInfoById(data.getBedID());
        b.setAvailability(data.isAvailability());
        b.setGravity(data.getGravity());
        b.setLabel(data.getLabel());
        b.setIntubation(data.isIntubation());
        b.setO2(data.getO2());
        bedDao.save(b);
    }else {

        Bed b= new Bed();
        Services s=srvcDao.findServicesID(data.getSrvcID());
        b.setAvailability(data.isAvailability());
        b.setGravity(data.getGravity());
        b.setLabel(data.getLabel());
        b.setIntubation(data.isIntubation());
        b.setO2(data.getO2());
        b.setServices(s);
        bedDao.save(b);
    }
        return null;
    }


    @Override
    public BedStatInfo getOrgBedStatInfo(long orgID) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
                BedStatInfo info = new BedStatInfo();
                Organization org=this.orgDao.getOrganizationById(orgID);
                info.setCountryID(org.getCity().getCityRegion().getCoutryRegion().getCountryID());
                info.setCountryName(org.getCity().getCityRegion().getCoutryRegion().getNomFr());
                info.setRegionID(org.getCity().getCityRegion().getRegionID());
                info.setRegionName(org.getCity().getCityRegion().getName());
                info.setCityID(org.getCity().getCityID());
                info.setCityName(org.getCity().getName());
                info.setOrgID(orgID);
                info.setOrgName(org.getOrgName());
                List<BedInfo> beds = new ArrayList<BedInfo>();
                BedInfo bed = new BedInfo();
                int totalO2 = 0;
                int totalTmpO2=0;
                int totalBed = bedDao.totalBedCountByOrg(orgID);
                int totalBedAvailbal = bedDao.totalBedAvailbalByOrg(orgID);
                int totalBedintubation = bedDao.totalIntubationByOrg(orgID);
                int totalMinor = bedDao.totalMinorByOrg(orgID);
                int totalMajor = bedDao.totalMajorByOrg(orgID);
                int totalCritical = bedDao.totaCriticalByOrg(orgID);
                if (totalBed > 0  && totalBed!=totalBedAvailbal) {
                    totalO2 = bedDao.totalO2ByOrg(orgID);
                }
                ///stat tmp

                int totalTmpBed = tmpBedDao.totalTmpBedCountByOrg(orgID);
                int totalTmpBedAvailbal = tmpBedDao.totalTmpBedAvailbalByOrg(orgID);
                int totalTmpBedintubation = tmpBedDao.totalTmpIntubationByOrg(orgID);
                int totalTmpMinor = tmpBedDao.totalTmpMinorByOrg(orgID);
                int totalTmpMajor = tmpBedDao.totalTmpMajorByOrg(orgID);
                int totalTmpCritical = tmpBedDao.totalTmpCriticalByOrg(orgID);
                if (totalTmpBed > 0  && totalTmpBed!=totalTmpBedAvailbal) {
                    totalTmpO2 = tmpBedDao.totalTmpO2ByOrg(orgID);
                }


                ////
                bed.setTotalBeds(totalBed+totalTmpBed);
                bed.setTotalavailbal(totalBedAvailbal+totalTmpBedAvailbal);
                bed.setTotalIntubation(totalBedintubation+totalTmpBedintubation);
                bed.setMinor(totalMinor+totalTmpMinor);
                bed.setMajor(totalMajor+totalTmpMajor);
                bed.setCritical(totalCritical+totalTmpCritical);
                bed.setO2(totalO2+totalTmpO2);

                beds.add(bed);
                info.setBed(beds);
                return info;
    }

}
