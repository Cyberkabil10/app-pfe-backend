package com.allodoc.tn.covibed.services.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IRoleDao;
import com.allodoc.tn.covibed.model.Role;
import com.allodoc.tn.covibed.services.IRoleService;
import com.allodoc.tn.covibed.tools.RoleInfo;

@Service
public class RoleSrvImp  implements IRoleService{
@Autowired
IRoleDao rlDao;
    @Override
    public List<RoleInfo> getAllRole() {
        List<RoleInfo> result= new ArrayList<RoleInfo>();
        List<Role> rls=rlDao.findAll();
        if(rls!=null) {
            for(Role rl:rls) {
                RoleInfo r =new RoleInfo();
                r.setName(rl.getName());
                r.setRoleID(rl.getId());
                result.add(r);

            }

        }
        return result;
    }

}
