package com.jxau.kknq.service.impl;

import org.springframework.stereotype.Component;

import java.security.Security;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/2 15:56
 */
@Component
public class SendMailImpl {
    public String sendMail(){
        try {
            //设置SSL连接、邮件环境
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtp.auth", "true");
            //建立邮件会话
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                //身份认证
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1915029771@qq.com", "gkhofzbqxgejbaff");
                }
            });
            //建立邮件对象
            MimeMessage message = new MimeMessage(session);
            //设置邮件的发件人、收件人、主题
            //附带发件人名字
            message.setFrom(new InternetAddress("1915029771@qq.com"));
            message.setRecipients(Message.RecipientType.TO, "617764428@qq.com");
            message.setSubject("通过javamail发出！！！");
            //文本部分
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent("注册邮件！！", "text/html;charset=UTF-8");
            //发送邮件
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
        return "OK";
    }
}
