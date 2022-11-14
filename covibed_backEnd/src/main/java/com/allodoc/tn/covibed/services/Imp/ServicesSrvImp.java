package com.allodoc.tn.covibed.services.Imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IOrganizationDao;
import com.allodoc.tn.covibed.dao.IServicesDao;
import com.allodoc.tn.covibed.model.Organization;
import com.allodoc.tn.covibed.model.Services;
import com.allodoc.tn.covibed.services.IServicesService;
import com.allodoc.tn.covibed.tools.ServicesBody;
@Service
public class ServicesSrvImp  implements IServicesService{
@Autowired
IServicesDao srvDao;
@Autowired
IOrganizationDao orgDao;
@Transient
@Value("${server.url}")
private String serverUrl;
    @Override
    public List<ServicesBody> getOrganizationServices(long orgID) {
        List<ServicesBody> result = new ArrayList<ServicesBody>();
        List<Services> srvs=srvDao.findAllServicesByOrgID(orgID);
        if(srvs!=null && !srvs.isEmpty()) {
            for(Services s:srvs) {
                ServicesBody r=new ServicesBody();
                r.setSrvID(s.getSrvID());
                r.setSrvName(s.getServicesName());
                r.setImgUrl(s.getImgurl());
                r.setCityName(s.getOrganization().getCity().getName());
                r.setRegionName(s.getOrganization().getCity().getCityRegion().getName());
                result.add(r);
            }
        }
        return result;
    }

    @Override
    public Object addOrUpdateService(ServicesBody data) {
        String url = (String.format("%s", serverUrl) + "/view/" + "image/" + data.getImageName());
        if(data.getSrvID()==0) {
            Organization o= orgDao.getOrganizationById(data.getOrgID());
            Services s = new Services();
            s.setServicesName(data.getSrvName());
            s.setImgurl(url);
            s.setOrganization(o);
            srvDao.save(s);
            return s;
        }else {
            Services s=srvDao.findServicesID(data.getSrvID());
            s.setServicesName(data.getSrvName());
            s.setImgurl(url);
            srvDao.save(s);
            return s;
        }
    }

    @Override
    public List<ServicesBody> getServicesList(long orgID) {
        List<ServicesBody> result = new ArrayList<ServicesBody>();
        List<Services> srvs=srvDao.filAllServiices(orgID);
        if(srvs!=null && !srvs.isEmpty()) {
            for(Services s:srvs) {
                ServicesBody r=new ServicesBody();
                r.setSrvID(s.getSrvID());
                r.setSrvName(s.getServicesName());
                r.setImgUrl(s.getImgurl());
                r.setCityName(s.getOrganization().getCity().getName());
                r.setRegionName(s.getOrganization().getCity().getCityRegion().getName());
                result.add(r);
            }
        }
        return result;
    }

}
