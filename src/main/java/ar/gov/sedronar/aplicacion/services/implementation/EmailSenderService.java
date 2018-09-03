package ar.gov.sedronar.aplicacion.services.implementation;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ar.gov.sedronar.aplicacion.util.ConfigProperties;

import java.util.Properties;


public class EmailSenderService {

    public void sendEmail(String to, String code) throws Exception{ //, Boolean olvidoContrasenia) {
        String from = "";//ConfigProperties.getInstance().getEmailFrom();

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        //get Session
        Authenticator auth = new SMTPAuthenticator();
        //    Session session = Session.getDefaultInstance(props, auth);
        Session session = Session.getInstance(props, auth);
        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(from));
        String url = "";//ConfigProperties.getInstance().getUrlChangePassword() + code;
        msg.setSubject("[Back Office] Restablecer contraseña");
        String messageBody = String.format("Para modificar su clave haga "
                + "<a href=\"%s\"> click aquí.</a><br><br>"
                + "Si no usa el link en las próximas 6 horas, expirará.<br><br>"
                + "Gracias.", url);
        msg.setContent(messageBody, "text/html; charset=utf-8");
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        Transport.send(msg);
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String from = "";//ConfigProperties.getInstance().getEmailFrom();
            String password ="";// ConfigProperties.getInstance().getEmailPassword();
            return new PasswordAuthentication(from, password);
        }
    }
}