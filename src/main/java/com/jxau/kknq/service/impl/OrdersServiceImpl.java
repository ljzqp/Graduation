package com.jxau.kknq.service.impl;

import com.jxau.kknq.bean.OrderDetails;
import com.jxau.kknq.entity.Orders;
import com.jxau.kknq.entity.Users;
import com.jxau.kknq.repository.OrdersRepository;
import com.jxau.kknq.repository.UserRepository;
import com.jxau.kknq.service.OrdersService;
import com.jxau.kknq.util.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/8 15:42
 */
@Service("OrdersService")
public class OrdersServiceImpl implements OrdersService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Override
    public int submitOrder(String username,OrderDetails orderDetails) {
        Users user = userRepository.getUsersByUsername(username);
        Orders orders = new Orders();
        int productId = Integer.valueOf(orderDetails.getProductId());
        orders.setAddress(orderDetails.getAddress());
        orders.setAmount(Float.valueOf(orderDetails.getPrice()));
        orders.setBuyWay(Integer.valueOf(orderDetails.getPayWay()));
        orders.setContactTel(orderDetails.getContact());
        orders.setDeliverTime(DateUtils.parse(orderDetails.getDeliverDate(),DateUtils.UI_FORMAT));
        orders.setDeliverStartTime(orderDetails.getDeliverStartTime());
        orders.setDeliverEndTime(orderDetails.getDeliverEndTime());
        orders.setContact(username);
        orders.setCreateTime(new Date());
        if("到店自提".equals(orderDetails.getDeliverWay())){
            orders.setDeliverType(0);
        }
        else if ("员工配送".equals(orderDetails.getDeliverWay())){
            orders.setDeliverType(1);
        }
        orders.setOrderTime(new Date());
        orders.setStatus(7); // 7-待付款
        orders.setPayAmount(Float.valueOf(orderDetails.getPrice()));
        orders.setProductId(productId);

        int id = ordersRepository.save(orders).getId();
        System.out.println("IDIDIDIDID+"+id);
        return user.getId();
    }

    @Override
    public Orders getOrdersById(int id) {

        Orders orders = ordersRepository.findOne(id);

        return null;
    }
}
