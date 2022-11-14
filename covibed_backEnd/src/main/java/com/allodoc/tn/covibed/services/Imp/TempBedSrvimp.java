package com.allodoc.tn.covibed.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IServicesDao;
import com.allodoc.tn.covibed.dao.ITempBedDao;
import com.allodoc.tn.covibed.model.Bed;
import com.allodoc.tn.covibed.model.Services;
import com.allodoc.tn.covibed.model.TempBed;
import com.allodoc.tn.covibed.services.ITempBedService;
import com.allodoc.tn.covibed.tools.BedInfo;

@Service
public class TempBedSrvimp implements ITempBedService {
    @Autowired
    ITempBedDao tmpBedDao;
    @Autowired
    IServicesDao srvDao;

    @Override
    public BedInfo getNewtmpBedAvailbal() {
        TempBed b=tmpBedDao.findAvailbaltmpBed();
        if(b!=null) {

            return getTmpbedDetailInfo(b);
        }
        else {
            return null;
        }
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
    public BedInfo tieUptmpBedToSrv(long srvID) {
        Services srv= srvDao.findServicesID(srvID);
        TempBed b=tmpBedDao.findAvailbaltmpBed();
        b.setServices(srv);
        tmpBedDao.save(b);
        return getTmpbedDetailInfo(b);
    }

    @Override
    public BedInfo releaseTmpBed(long tmpBedID) {
        TempBed b=tmpBedDao.findTmpBedByID(tmpBedID);
        b.setServices(null);
        b.setGravity(0);
        b.setO2(0);
        b.setAvailability(true);
        b.setIntubation(false);
        tmpBedDao.save(b);
        return getTmpbedDetailInfo(b);
    }

    @Override
    public Object addOrUpdateTmpBed(BedInfo data) {
        TempBed b=tmpBedDao.findTmpBedByID(data.getBedID());
        b.setAvailability(data.isAvailability());
        b.setGravity(data.getGravity());
        b.setIntubation(data.isIntubation());
        b.setO2(data.getO2());
        tmpBedDao.save(b);
        return getTmpbedDetailInfo(b);
    }

}
