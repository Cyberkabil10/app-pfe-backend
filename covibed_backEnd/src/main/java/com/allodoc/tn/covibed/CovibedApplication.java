package com.allodoc.tn.covibed;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;

import com.allodoc.tn.covibed.Utils.ScheduledFunction;
import com.allodoc.tn.covibed.services.Imp.StorageProperties;

import freemarker.template.TemplateException;
@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
@SpringBootApplication
public class CovibedApplication {
    @Autowired
    private ScheduledFunction schedulServices;
    public static void main(String[] args) {
        SpringApplication.run(CovibedApplication.class, args);
    }

//    @Scheduled(cron="0 0 0 1 1/1 *")
//    public void updatePassword() throws IOException, TemplateException {
//        schedulServices.updatePAssword();
//    }
}
