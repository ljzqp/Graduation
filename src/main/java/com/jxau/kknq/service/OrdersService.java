package com.jxau.kknq.service;

import com.jxau.kknq.bean.OrderDetails;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/8 15:36
 */
public interface OrdersService {

    int submitOrder(String username,OrderDetails orderDetails);
}
