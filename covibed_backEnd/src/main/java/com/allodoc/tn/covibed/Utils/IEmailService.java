package com.allodoc.tn.covibed.Utils;

public interface IEmailService {

    public void send(String from,String to, String subject, String text);
    public void send(String from,String to, String cc,String subject, String text);
}
