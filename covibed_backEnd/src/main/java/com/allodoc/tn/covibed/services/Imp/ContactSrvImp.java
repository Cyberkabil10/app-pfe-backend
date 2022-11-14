package com.allodoc.tn.covibed.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IContactDao;
import com.allodoc.tn.covibed.dao.IDoctorsDao;
import com.allodoc.tn.covibed.dao.IStaffDao;
import com.allodoc.tn.covibed.dao.IUserDao;
import com.allodoc.tn.covibed.model.Contact;
import com.allodoc.tn.covibed.model.Role;
import com.allodoc.tn.covibed.model.User;
import com.allodoc.tn.covibed.services.IContactservice;

@Service
public class ContactSrvImp  implements IContactservice{
@Autowired
IContactDao cntDao;
@Autowired
IUserDao usrDao;
@Autowired
IDoctorsDao dctDao;
@Autowired
IStaffDao stfDao;
    @Override
    public void deleteContact(long contactID) {
        Contact c =cntDao.findContactById(contactID);
        User user=c.getUser();
        if(c.getDoctors()!=null) {
            dctDao.deleteDocByID(c.getDoctors().getDoctorID());
        }
        if(c.getStaff()!=null) {
            stfDao.deleteStaffcByID(c.getStaff().getStaffID());
        }

        if(!user.getRoles().isEmpty()) {
             List<Role> usrRole=user.getRoles();
             for(int i=0;i<usrRole.size();i++) {
                    Role r = usrRole.get(i);
                    usrDao.deleteRole(r.getId(),user.getId());
                }
           }
        usrDao.deleteUserById(user.getId());
        cntDao.deleteConatctByID(c.getContactID());
    }
}
