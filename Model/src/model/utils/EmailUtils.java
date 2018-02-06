package model.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import oracle.adf.share.logging.ADFLogger;

public class EmailUtils {
    private static ADFLogger _logger = ADFLogger.createADFLogger(EmailUtils.class);
    public EmailUtils() {
        super();
    }
    
    public static boolean sendEmail(String recepient, Map<String,String> email, byte[] bytes) {
        //String host = "smtp.gmail.com",port = "587",sender="morgan.franklin.test@gmail.com";
        //String host = "smtp.office365.com",port = "587",sender="nkoneru@morgan-franklin.com";
        String host = "sldcsmtp.atoracle.com",sender="tzarzycki@covanta.com";
        _logger.info("Inside sendEmail");
        MimeMessage message = null;
        Transport transport = null;
        try {
            if (host != null && host.trim().length() > 0) {
                _logger.info("Inside IF Block");
                Session session = getMailSession(host);
                _logger.info("After getMailSession");
                message = new MimeMessage(session);
                _logger.info("After MimeMessage");
                message.setFrom(new InternetAddress(sender));
                _logger.info("After setFrom");
                message.setSubject(checkIfNull(email.get("EMAIL_SUBJECT")));
                _logger.info("setSubject");
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                _logger.info("setRecipients");
                Multipart mp = new MimeMultipart();
                _logger.info("MimeMultipart");
                MimeBodyPart mbp1 = new MimeBodyPart();
                _logger.info("MimeBodyPart");
                mbp1.setContent(checkIfNull(email.get("EMAIL_BODY")), "text/html; charset=utf-8");
                _logger.info("setContent");
                mp.addBodyPart(mbp1);
                _logger.info("addBodyPart");
                if (null != bytes) {
                    _logger.info("Inside bytes IF Block");
                    MimeBodyPart mbp2 = new MimeBodyPart();
                    _logger.info("Inside bytes IF Block  MimeBodyPart");
                    ByteArrayDataSource bds = new ByteArrayDataSource(bytes, "application/octet-stream");
                    _logger.info("Inside bytes IF Block ByteArrayDataSource");
                    mbp2.setDataHandler(new DataHandler(bds));
                    _logger.info("Inside bytes IF Block setDataHandler");
                    mbp2.setFileName(checkIfNull(email.get("EMAIL_ATTACHMENT_NAME")));
                    _logger.info("Inside bytes IF Block setFileName");
                    mp.addBodyPart(mbp2);
                    _logger.info("Inside  bytes IF Block addBodyPart");
                }
                _logger.info("Afetr bytes IF Block");
                message.setContent(mp);
                _logger.info("After bytes IF Block setContent");
                //transport = session.getTransport();
                _logger.info("After bytes IF Block setContent");
                //transport.connect();
                _logger.info("After bytes IF Block connect");
                //Transport.send(message, message.getAllRecipients());
                Transport.send(message);
                _logger.info("After bytes IF Block send");
                //transport.close();
                _logger.info("After bytes IF Block close");
                return true;
            }
        } catch (Exception ex) {
            // TODO: Add catch code
            ex.printStackTrace();
            _logger.info("Inside Catch Block: "+ ex.getLocalizedMessage());
        } 
//        catch (NoSuchProviderException nspe) {
//            // TODO: Add catch code
//            nspe.printStackTrace();
//        } catch (MessagingException me) {
//            // TODO: Add catch code 
//            me.printStackTrace();
//        }
    return false;
    }
    
    /*private static Session getMailSession(String host, String port, String sender) {

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
    }*/
    
    private static Session getMailSession(String host) {

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(props);
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
