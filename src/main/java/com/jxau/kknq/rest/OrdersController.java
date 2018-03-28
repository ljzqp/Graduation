package com.jxau.kknq.rest;

import com.jxau.kknq.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/28 17:06
 */
@Controller
public class OrdersController {

    @Autowired
    ProductsService productsService;

    @GetMapping(value = "orders")
    public String getOrdersPage(){
        System.out.println("orders+");
        return "order";
    }
}
