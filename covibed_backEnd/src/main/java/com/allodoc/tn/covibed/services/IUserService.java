package com.allodoc.tn.covibed.services;

import java.util.List;

import com.allodoc.tn.covibed.model.Contact;
import com.allodoc.tn.covibed.tools.UserBody;
import com.allodoc.tn.covibed.tools.UserInfo;

public interface IUserService {

    UserInfo getUserInfo(String userName);

    void logout(long id);

    List<UserInfo> getUserByRegion(long regionID);

    List<UserInfo> getDctUserByOrg(long orgID);

    List<UserInfo> getStaffUserByOrg(long orgID);

    boolean checkUserName(String username);

    void addUserOrupdate(UserBody data);

}
