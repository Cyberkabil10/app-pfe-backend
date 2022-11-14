package com.allodoc.tn.covibed.Utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;






@Service
@Component("exisauthAsynchMailSender")
public class EmailAsyncService implements IEmailService {

    @Autowired
    public JavaMailSender mailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void send(String from,String to, String cc,String subject, String text) {
        // TODO Auto-generated method stub
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper mailMsg=null;
                logger.info("send, entering send mail ...");
                try {
                    mailMsg = new MimeMessageHelper(mimeMessage, true);
                    mailMsg.setFrom(from);
                    mailMsg.setTo(to);
                    mailMsg.setCc(cc);
                    mailMsg.setSubject(subject);
                    mailMsg.setText(text,true);

                } catch (MessagingException e) {
                    // TODO Auto-generated catch block
                    logger.error("::send, Error while build email message: "+e.getMessage());
                }
                logger.debug("send, sending email message subjec:"+subject+" / From:"+from+" / To="+to);
                taskExecutor.execute(new SimpleMailMessageRunnable(mimeMessage));
    }

    @Override
    public void send(String from,String to, String subject, String text) {
        // TODO Auto-generated method stub
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailMsg=null;
        logger.info("send, entering send mail ...");
        try {
            mailMsg = new MimeMessageHelper(mimeMessage, true);
            mailMsg.setFrom(from);
            mailMsg.setTo(to);

            mailMsg.setSubject(subject);
            mailMsg.setText(text,true);

        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            logger.error("::send, Error while build email message: "+e.getMessage());
        }
        logger.debug("send, sending email message subjec:"+subject+" / From:"+from+" / To="+to);
        taskExecutor.execute(new SimpleMailMessageRunnable(mimeMessage));
    }

    private class SimpleMailMessageRunnable implements
    Runnable {
       private MimeMessage message;

       private SimpleMailMessageRunnable(MimeMessage simpleMailMessage) {
         this.message = simpleMailMessage;
       }

       public void run() {
           logger.info("::SimpleMailMessageRunnable, start sending message");
           mailSender.send(message);
           logger.info("::SimpleMailMessageRunnable, Email Sent successfully !!");

       }
    }

}
