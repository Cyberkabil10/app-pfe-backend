package com.Med.authentication.teleConsult.services.Imp;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Med.authentication.teleConsult.dao.IActivitesLogoutDao;
import com.Med.authentication.teleConsult.dao.UserRepository;
import com.Med.authentication.teleConsult.model.ActivitesLogout;
import com.Med.authentication.teleConsult.model.User;
import com.Med.authentication.teleConsult.services.IActivitesLogoutServices;

@Service
public class ActivitesLogoutServicesImp implements IActivitesLogoutServices{

    @Autowired
    IActivitesLogoutDao logDao;
    @Autowired
    UserRepository userservices;
    @Override
    public void addloginActivity(String username) {
//        User user =userservices.findUserByUserName(username);


        ActivitesLogout activite = new ActivitesLogout();
        activite.setDate((java.sql.Date) new Date(System.currentTimeMillis()));
        activite.setType("logIn");
        activite.setUsername(username);
        logDao.save(activite);
    }

    @Override
    public void addlogoutActivity(String username) {
        User user =userservices.findByUsername(username);
        user.setStatus("Deconnecter");
        ActivitesLogout activite = new ActivitesLogout();
        activite.setDate((java.sql.Date) new Date(System.currentTimeMillis()));
        activite.setType("logout");
        activite.setUsername(username);
        logDao.save(activite);
    }

}
