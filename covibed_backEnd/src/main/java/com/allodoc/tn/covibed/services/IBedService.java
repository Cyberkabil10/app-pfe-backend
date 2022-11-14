package com.allodoc.tn.covibed.services;

import java.util.List;

import com.allodoc.tn.covibed.tools.BedInfo;
import com.allodoc.tn.covibed.tools.BedStatInfo;

public interface IBedService {
    List<BedStatInfo> getBedRegionOrganization(long regionID);

    List<BedStatInfo> getBedStatInfoByCountry(long countryId);

    BedStatInfo getCountryBedStatInfo(long countryId);

    List<BedStatInfo> getBedStatInfoByRegion(long regionId);

    BedStatInfo getRegionBedStatInfo(long regionId);

    List<BedStatInfo> getBedStatInfoByCity(long cityID);

    BedStatInfo getCityBedStatInfo(long cityId);

    List<BedStatInfo> getBedStatInfoByOrg(long orgId);

    BedStatInfo getOrganizationBedStatInfo(long orgId);

    List<BedStatInfo> getBedInfoDetailsByOrg(long orgId);

    BedStatInfo getBedInfoDetailsBySvc(long srvId);

    BedInfo getBedInfoById(long bedID);

    Object addOrUpdateBed(BedInfo data);

    BedStatInfo getOrgBedStatInfo(long orgID);

}
