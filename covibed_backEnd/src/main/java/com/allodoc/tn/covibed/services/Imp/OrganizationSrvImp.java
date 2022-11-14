package com.allodoc.tn.covibed.services.Imp;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IOrganizationDao;
import com.allodoc.tn.covibed.model.Organization;
import com.allodoc.tn.covibed.model.Services;
import com.allodoc.tn.covibed.services.IOrganizationService;
import com.allodoc.tn.covibed.tools.OrgBody;
import com.allodoc.tn.covibed.tools.ServicesBody;

@Service
public class OrganizationSrvImp implements IOrganizationService {
    @Autowired
    IOrganizationDao orgDao;
    @Transient
    @Value("${storage.location}")
    private Path filePath;
    @Transient
    @Value("${server.url}")
    private String serverUrl;
    @Override
    public List<OrgBody> getAllOrganization() {
        List<OrgBody> orgs = new ArrayList<OrgBody>();
        List<Organization> o = orgDao.findAll();

        if (o != null && !o.isEmpty()) {

            for (Organization or : o) {
                OrgBody result = new OrgBody();
                result.setImgUrl(or.getImgurl());
                result.setOrgID(or.getOrgID());
                result.setOrgName(or.getOrgName());
                result.setType(or.getType());
                List<Services> ser = or.getServices();
                if (ser != null && !ser.isEmpty()) {
                    List<ServicesBody> services = new ArrayList<ServicesBody>();
                    for (Services s : ser) {
                        ServicesBody ss = new ServicesBody();
                        ss.setImgUrl(s.getImgurl());
                        ss.setSrvID(s.getSrvID());
                        ss.setSrvName(s.getServicesName());
                        services.add(ss);
                    }
                    result.setServices(services);
                }
                orgs.add(result);
            }

            return orgs;
        } else {
            return orgs;
        }

    }

    public Path load(String filename) {
        return filePath.resolve(filename);
    }
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public Object addOrUpdateOrg(OrgBody data) {
        //
        String url = (String.format("%s", serverUrl) + "/view/" + "image/" + data.getImageName());
        if(data.getOrgID()==0) {
            Organization org = new Organization();
            org.setOrgName(data.getOrgName());
            org.setType(data.getType());
            org.setImgurl(url);
            orgDao.save(org);
            return org;
        }else {
            Organization org=orgDao.getOrganizationById(data.getOrgID());
            org.setOrgName(data.getOrgName());
            org.setType(data.getType());
            org.setImgurl(url);
            orgDao.save(org);
            return org;
        }

    }

    @Override
    public List<OrgBody> getorganizationByRegion(long regionId) {
        List<OrgBody> orgs = new ArrayList<OrgBody>();
        List <Organization> o=this.orgDao.findAllOrganisationByRegionID(regionId);
        if (o != null && !o.isEmpty()) {

            for (Organization or : o) {
                OrgBody result = new OrgBody();
                result.setImgUrl(or.getImgurl());
                result.setOrgID(or.getOrgID());
                result.setOrgName(or.getOrgName());
                result.setType(or.getType());
                result.setCityName(or.getCity().getName());
                result.setRegionName(or.getCity().getCityRegion().getName());
                List<Services> ser = or.getServices();
                if (ser != null && !ser.isEmpty()) {
                    List<ServicesBody> services = new ArrayList<ServicesBody>();
                    for (Services s : ser) {
                        ServicesBody ss = new ServicesBody();
                        ss.setImgUrl(s.getImgurl());
                        ss.setSrvID(s.getSrvID());
                        ss.setSrvName(s.getServicesName());
                        services.add(ss);
                    }
                    result.setServices(services);
                }
                orgs.add(result);
            }

            return orgs;
        } else {
            return orgs;
        }


    }
}
