package com.Med.authentication.teleConsult.utils;

import java.io.IOException;

import org.springframework.core.io.ResourceLoader;
import org.apache.commons.io.IOUtils;

public class MailHelper {

    private ResourceLoader resourceLoader_;
    private String mailConfirmationTmpl="";


    MailHelper(ResourceLoader resourceLoader){
        this.resourceLoader_=resourceLoader;
    }

    public String getHTMLContent(){
        String content=null;

        try {
            content = IOUtils.toString(resourceLoader_.getResource("").getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //logger.error("::loadHtmlTemplate, Error while loading property file: "+e.getMessage());
        }

        return content;
    }


}
