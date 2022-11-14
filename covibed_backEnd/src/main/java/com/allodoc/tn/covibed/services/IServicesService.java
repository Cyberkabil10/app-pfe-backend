package com.allodoc.tn.covibed.services;

import java.util.List;

import com.allodoc.tn.covibed.tools.ServicesBody;

public interface IServicesService {

    List<ServicesBody> getOrganizationServices(long orgID);

    Object addOrUpdateService(ServicesBody data);

    List<ServicesBody> getServicesList(long orgID);


}
