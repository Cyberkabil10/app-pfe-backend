package com.allodoc.tn.covibed.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IGeneralConfigDao;
import com.allodoc.tn.covibed.services.IGeneralConfigServices;

@Service
public class GeneralConfigSrvImp implements IGeneralConfigServices {
    @Autowired
    IGeneralConfigDao gnConfDao;
}
