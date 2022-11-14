package com.allodoc.tn.covibed.services;

import com.allodoc.tn.covibed.tools.BedInfo;

public interface ITempBedService {

    BedInfo getNewtmpBedAvailbal();

    BedInfo tieUptmpBedToSrv(long srvID);

    BedInfo releaseTmpBed(long tmpBedID);

    Object addOrUpdateTmpBed(BedInfo data);

}
