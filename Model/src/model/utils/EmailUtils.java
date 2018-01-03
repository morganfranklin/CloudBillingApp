package model.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
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
    
    public static boolean sendEmail(String recepient, Map<String,String> email, byte[] bytes) {
        String host = "smtp.gmail.com",port = "587",sender="morgan.franklin.test@gmail.com";
        
        MimeMessage message = null;
        Transport transport = null;
        try {
            if (host != null && port != null && host.trim().length() > 0 && port.trim().length() > 0) {
                Session session = getMailSession(host, port, sender);
                message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sender));
                message.setSubject(checkIfNull(email.get("EMAIL_SUBJECT")));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepient));
                
                Multipart mp = new MimeMultipart();
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setContent(checkIfNull(email.get("EMAIL_BODY")), "text/html; charset=utf-8");
                mp.addBodyPart(mbp1);
                
                if (null != bytes) {
                    MimeBodyPart mbp2 = new MimeBodyPart();
                    ByteArrayDataSource bds = new ByteArrayDataSource(bytes, "application/octet-stream");
                    mbp2.setDataHandler(new DataHandler(bds));
                    mbp2.setFileName(checkIfNull(email.get("EMAIL_ATTACHMENT_NAME")));
                    mp.addBodyPart(mbp2);
                }
                
                message.setContent(mp);
                transport = session.getTransport();
                transport.connect();
                transport.send(message, message.getAllRecipients());
                transport.close();
                return true;
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
    return false;
    }
    
    private static Session getMailSession(String host, String port, String sender) {

        Properties props = new Properties();
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.auth", "true");
        //props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.port", port);
//        props.setProperty("mail.smtp.user", sender);
//        props.setProperty("mail.debug", "true");
//        props.setProperty("mail.disable", "false");
//        props.setProperty("mail.verbose", "true"); 
        Session session = Session.getInstance(props,  
    new javax.mail.Authenticator() {  
     protected PasswordAuthentication getPasswordAuthentication() {  
      return new PasswordAuthentication(sender,"morganfranklin@TS");  
     }  
      });
        session.setDebug(true);
        return session;
    }
    
    private static String checkIfNull(String val){ 
        if(null==val || val.trim().length()==0)
          return "";
        else
          return val;
    }
    
    public static void main(String[] args) {
        StringBuilder html = new StringBuilder();
        String cust = null;
        //StringBuilder html = new StringBuilder();
        html.append("<p>");
        html.append("<b>Customer Name:</b>").append("&nbsp;&nbsp;").append(cust).append("<br><br>");
        html.append("<b>Sales Person:</b>").append("&nbsp;&nbsp;").append("Nirup Koneru").append("<br><br>");
        html.append("<b>Contract Start Date:</b>").append("&nbsp;&nbsp;").append("").append("<br><br>");
        html.append("<b>Contract End Date:</b>").append("&nbsp;&nbsp;").append("").append("<br><br>");
        html.append("<a href=\"");
        html.append("http://localhost:7101/neuCloudBilling1010/faces/adf.task-flow?adf.tfId=approvalWorkFlow&adf.tfDoc=/WEB-INF/approvalWorkFlow.xml");
        html.append("&").append("uuid=").append("").append("&").append("action=").append("ACCEPT");
        html.append("\"><b>Accept</b></a>");
        html.append("&nbsp;&nbsp;&nbsp;");
        html.append("<a href=\"");
        html.append("http://localhost:7101/neuCloudBilling1010/faces/adf.task-flow?adf.tfId=approvalWorkFlow&adf.tfDoc=/WEB-INF/approvalWorkFlow.xml");
        html.append("&").append("uuid=").append("").append("&").append("action=").append("REJECT");
        html.append("\"><b>Reject</b></a>");
        html.append("</p>");
        //"<p><a href="https://www.w3schools.com/html/default.asp">HTML tutorial</a></p>";
        EmailUtils.sendEmail("nkoneru@morganfranklin.com",new HashMap<String,String>(),null);
    }
}
