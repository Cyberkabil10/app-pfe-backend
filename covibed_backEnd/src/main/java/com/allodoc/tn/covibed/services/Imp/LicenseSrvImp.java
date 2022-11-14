package com.allodoc.tn.covibed.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.ILicenseDao;
import com.allodoc.tn.covibed.dao.IUserDao;
import com.allodoc.tn.covibed.model.License;
import com.allodoc.tn.covibed.services.ILicenseServices;
import com.allodoc.tn.covibed.tools.LicenseInfo;
@Service
public class LicenseSrvImp implements ILicenseServices {
    @Autowired
    ILicenseDao lscDao;
    @Autowired
    IUserDao usrDao;

    @Override
    public LicenseInfo getLicenseByRegion(long regionID) {
        License l=lscDao.findLicensebyRegion(regionID);
        LicenseInfo result= new LicenseInfo();
        if(l!=null) {
            result.setLicenseID(l.getLicenseID());
            result.setNbr(l.getNbr());
            result.setRegionID(l.getRegion().getRegionID());
            int count= usrDao.getUserCountbyRegion(regionID);

            result.setUserNbr(count);



            return result;
        }else {
            return result;
        }

    }
}
