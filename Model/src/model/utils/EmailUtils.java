package model.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class EmailUtils {
    public EmailUtils() {
        super();
    }
    
    public static void sendEmail(String host, String port, String sender, String recepient, String subject,
                                 String emailBody) {

        MimeMessage message = null;
        Transport transport = null;
        try {
            if (host != null && port != null && host.trim().length() > 0 && port.trim().length() > 0) {
                Session session = getMailSession(host, port, sender);
                message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sender));
                message.setSubject(subject);
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
                
                Multipart mp = new MimeMultipart();
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(emailBody, "text/html; charset=utf-8");
                mp.addBodyPart(mbp1);
                message.setContent(mp);
                transport = session.getTransport();
                transport.connect();
                transport.send(message, message.getAllRecipients());
                transport.close();
            }
        } catch (AddressException ae) {
            // TODO: Add catch code
            ae.printStackTrace();
        } catch (NoSuchProviderException nspe) {
            // TODO: Add catch code
            nspe.printStackTrace();
        } catch (MessagingException me) {
            // TODO: Add catch code
            me.printStackTrace();
        }
    }
    
    private static Session getMailSession(String host, String port, String sender) {

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.user", sender);
        props.setProperty("mail.debug", "true");
        props.setProperty("mail.disable", "false");
        props.setProperty("mail.verbose", "true");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        return session;
    }
}
