package com.allodoc.tn.covibed.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IOrgParameterDao;
import com.allodoc.tn.covibed.services.IOrgParameterServices;

@Service
public class OrgParameterSrvImp implements IOrgParameterServices {
    @Autowired
    IOrgParameterDao orgprmDao;
}
