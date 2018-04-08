package com.jxau.kknq;

import com.jxau.kknq.entity.OrderItems;
import com.jxau.kknq.entity.Orders;
import com.jxau.kknq.repository.OrderItemsRepository;
import com.jxau.kknq.repository.OrdersRepository;
import com.jxau.kknq.util.RandomUtil;

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
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrderItemsRepository itemsRepository;
    private static final long INFOLD_FLAG = 1517126919910L;

    @Test
    public void contextLoads() {
        Orders orders =new Orders();
        orders.setAddress("sss");
        orders.setAmount(20.f);
        ordersRepository.save(orders);

        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(100.f);
        orderItems.setOrder(orders);
        itemsRepository.save(orderItems);

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
    @Test
    public void random(){
        System.out.println(RandomUtil.randomCode());
    }

}

