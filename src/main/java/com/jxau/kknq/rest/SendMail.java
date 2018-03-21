package com.jxau.kknq.rest;

import org.springframework.stereotype.Component;

import java.security.Security;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//发送一封图文加附件的邮件
@Component
public class SendMail {
    public static void main(String[] args) {
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
            message.setRecipients(Message.RecipientType.TO, "809687373@qq.com");
            message.setSubject("通过javamail发出！！！");
            //文本部分
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent("欢迎注册可可浓情~~验证码为：626520", "text/html;charset=UTF-8");
            //内嵌图片部分
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setDataHandler(new DataHandler(new FileDataSource("C:\\报表异常处理.jpg")));//图片路径
            imagePart.setContentID("myimg");
            //图文整合，关联关系
            MimeMultipart mmp1 = new MimeMultipart();
            mmp1.addBodyPart(textPart);
            mmp1.addBodyPart(imagePart);
            mmp1.setSubType("related");
            MimeBodyPart textImagePart = new MimeBodyPart();
            textImagePart.setContent(mmp1);
            //附件部分
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataHandler dh = new DataHandler(new FileDataSource("E:\\ck\\ZhuGo\\pom.xml"));//文件路径
            String fileName = dh.getName();
            attachmentPart.setDataHandler(dh);
            attachmentPart.setFileName(fileName);
            //图文和附件整合，复杂关系
            MimeMultipart mmp2 = new MimeMultipart();
            mmp2.addBodyPart(textImagePart);
            mmp2.addBodyPart(attachmentPart);
            mmp2.setSubType("mixed");
            //将以上内容添加到邮件的内容中并确认
            message.setContent(mmp2);
            message.saveChanges();
            //发送邮件
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}