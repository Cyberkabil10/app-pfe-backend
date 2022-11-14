package com.allodoc.tn.covibed.services;

import java.nio.file.Path;
import java.util.List;

import org.springframework.core.io.Resource;

import com.allodoc.tn.covibed.tools.OrgBody;

public interface IOrganizationService {

    List<OrgBody> getAllOrganization();

    Path load(String filename);

    Resource loadAsResource(String filename);

    Object addOrUpdateOrg(OrgBody org);

    List<OrgBody> getorganizationByRegion(long regionId);

}
