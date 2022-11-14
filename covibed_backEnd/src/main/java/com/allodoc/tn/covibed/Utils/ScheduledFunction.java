package com.allodoc.tn.covibed.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.ModelAndView;

import com.allodoc.tn.covibed.Utils.IEmailService;
import com.allodoc.tn.covibed.dao.IOrganizationDao;
import com.allodoc.tn.covibed.dao.IRegionDao;
import com.allodoc.tn.covibed.dao.IServicesDao;
import com.allodoc.tn.covibed.dao.IUserDao;
import com.allodoc.tn.covibed.model.Organization;
import com.allodoc.tn.covibed.model.Region;
import com.allodoc.tn.covibed.model.Services;
import com.allodoc.tn.covibed.model.User;
import com.allodoc.tn.covibed.tools.MailBody;
import com.allodoc.tn.covibed.tools.MailInfo;
import com.allodoc.tn.covibed.tools.SrvInfo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.micrometer.core.instrument.util.IOUtils;
@Service
public class ScheduledFunction {
    @Autowired
    private Configuration freemarkerConfig;

    @Autowired
    @Qualifier("exisauthAsynchMailSender")
    IEmailService mailingService;

    @Autowired
    ResourceLoader resourceLoader_;
    private String mail = "classpath:/static/emailtemplate/Mail-MISEaJOUR.html";
    @Autowired
    IRegionDao rgDao;






    @Autowired
    IUserDao usrDao;

    @Autowired
    IOrganizationDao orgDao;
    @Autowired
    IServicesDao srvDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void updatePAssword( ) throws IOException, TemplateException {

        logger.info("ScheduledFunction:::::: updatePAssword() =====> Starting!");
        List<Region> Reg=rgDao.findAllRegionWithOrgByContryID(199);
          if(Reg!=null && !Reg.isEmpty()) {
              for (Region region : Reg) {
              long regID=region.getRegionID();
              List<Organization> os = orgDao.findAllOrganisationByRegionIDWithServicesEmailActive(regID);
              if (os != null && !os.isEmpty()) {
                    List<MailBody> mlbds = new ArrayList<MailBody>();
                    for (Organization o : os) {
                        MailBody mlbd = new MailBody();
                        mlbd.setOrgName(o.getOrgName());
                        mlbd.setRegioName(o.getCity().getCityRegion().getName());
                        List<Services> srvs = srvDao.findAllServicesByOrgID(o.getOrgID());
                        if (srvs != null && !srvs.isEmpty()) {
                            List<SrvInfo> services = new ArrayList<SrvInfo>();
                            for (Services s : srvs) {
                                 SrvInfo sInf= new SrvInfo();
                                  sInf.setSrvNAme(s.getServicesName());
                                  sInf.setOrgNAme(s.getOrganization().getOrgName());
                                  sInf.setRegionName(s.getOrganization().getCity().getCityRegion().getName());
                               List<User> DctUser=usrDao.finAllGrdDctUserBySrv(s.getSrvID());

                               if (DctUser != null && !DctUser.isEmpty()) {
                                   List<MailInfo> mailinfo = new ArrayList<MailInfo>();
                                   for (User u : DctUser) {
                                       String newPassword=randomPAssword();
                                       u.setPassword(passwordEncoders(newPassword));
                                       usrDao.save(u);
                                      MailInfo m = new  MailInfo();
                                       m.setNom(u.getContact().getPrenom()+" "+u.getContact().getNom());
                                       m.setUsername(u.getUsername());
                                       m.setPassword(newPassword);
                                       mailinfo.add(m);
                                   }
                                   sInf.setUser(mailinfo);
                                   User srvGen=usrDao.findSrvGenUserBySrv(s.getSrvID());
                                   if(srvGen!=null && srvGen.getEmail()!=null) {
                                       SendServEMail(sInf,srvGen.getEmail()) ;
                                      }

                               }
                               services.add(sInf) ;
                            }
                            mlbd.setServices(services);
                        }
                        mlbds.add(mlbd);
                    }
                     User DGen=usrDao.findAdminyReg(regID);
                     if(DGen!=null && DGen.getEmail()!=null) {
                         SendDrGnEMail(mlbds,DGen.getEmail()) ;
                        }
                }


          }

          }



        logger.info("ScheduledFunction:::::: updatePAssword() =====> execute succssefully!");

    }

    public void SendServEMail(SrvInfo result,String email) throws IOException, TemplateException {
        logger.info("ScheduledFunction:::::: SendEMail() =====> Starting!");
        Map<String, SrvInfo> map = new HashMap();
        map.put("DATA", result);

        Template t = freemarkerConfig.getTemplate("Mail-SrvMISEaJOUR.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
        mailingService.send("guide@exis-it.com", email, "covibed : mail de mise a jour", html);

    }
    public void SendDrGnEMail(List<MailBody> result,String email) throws IOException, TemplateException {
        logger.info("ScheduledFunction:::::: SendDrGnEMail() =====> Starting!");
        Map<String, List<MailBody>> map = new HashMap();
        map.put("DATA", result);

        Template t = freemarkerConfig.getTemplate("Mail-DrGenMISEaJOUR.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
        mailingService.send("guide@exis-it.com", email, "covibed : mail de mise a jour", html);

    }

    public String randomPAssword() {

        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return generatedString;

    }

    public String passwordEncoders(String pwd) {
        String encodedPwd = "";
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        encodedPwd = encoder.encode(pwd);
        return encodedPwd;

    }



}
