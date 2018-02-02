package com.jxau.kknq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KknqApplicationTests {

    @Autowired
    private JavaMailSender mailSender;
    private static final long INFOLD_FLAG = 1517126919910L;

    @Test
    public void contextLoads() {
        long userId = System.currentTimeMillis() - INFOLD_FLAG;
//		System.out.println(System.currentTimeMillis()-1234);
        System.out.println(userId);
    }

    /**
     * 修改application.properties的用户，才能发送。
     */

    @Test
    public void sendSimpleEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1915029771@qq.com");//发送者.
        message.setTo("617764428@qq.com");//接收者.
        message.setSubject("测试邮件（邮件主题）");//邮件主题.
        message.setText("爸爸爱你！！");//邮件内容.
        mailSender.send(message);//发送邮件
    }

}

