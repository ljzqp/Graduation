package com.jxau.kknq.rest;

import com.jxau.kknq.bean.OrderDetails;
import com.jxau.kknq.entity.Orders;
import com.jxau.kknq.service.OrdersService;
import com.jxau.kknq.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/28 17:06
 */
@Controller
public class OrdersController {

    @Autowired
    ProductsService productsService;

    @Autowired
    OrdersService ordersService;

    @GetMapping(value = "orders")
    public String getOrdersPage(){
        return "order";
    }

    @PostMapping(value = "send/order")
    @ResponseBody
    public int sendOrderDetails(@RequestBody OrderDetails orderDetails, Model model,HttpSession session){
        model.addAttribute("orderDetails",orderDetails);
        String username = (String) session.getAttribute("username");
        System.out.println("DADADADADADADA"+username);
        System.out.println("ssss+++"+orderDetails);
        return ordersService.submitOrder(username,orderDetails);
    }

    @GetMapping(value = "get/orders")
    @ResponseBody
    public Orders getOrders(@RequestParam("id") int id){
        return ordersService.getOrdersById(id);
    }

}
