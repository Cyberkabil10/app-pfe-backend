package com.allodoc.tn.covibed.services.Imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allodoc.tn.covibed.dao.IJobTitleDao;
import com.allodoc.tn.covibed.model.JobTitle;
import com.allodoc.tn.covibed.services.IJobTitleServices;
import com.allodoc.tn.covibed.tools.JobInfo;
@Service
public class JobTitleSrvImp implements IJobTitleServices{
@Autowired
IJobTitleDao jbDao;

    @Override
    public List<JobInfo> getAllJob() {
        List<JobInfo> result= new ArrayList<JobInfo>();
        List<JobTitle> jbs=jbDao.findAll();
        if(jbs!=null) {
            for(JobTitle j:jbs) {
                JobInfo r =new JobInfo();
                r.setDescription(j.getDescription());
                r.setName(j.getName());
                r.setJobTitleID(j.getJobTitleID());

                result.add(r);

            }

        }
        return result;
    }

}
