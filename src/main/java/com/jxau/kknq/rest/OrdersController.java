package com.jxau.kknq.rest;

import com.jxau.kknq.bean.OrderDetails;
import com.jxau.kknq.service.ProductsService;
import com.sun.deploy.net.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public String getOrdersPage(@ModelAttribute(value = "orderDetails") OrderDetails orderDetails,HttpServletRequest request, HttpResponse response){
//        String productTitle = orderDetails.getProductTitle();
        System.out.println(orderDetails);
        return "order";
    }

    @PostMapping(value = "send/order")
    @ResponseBody
    public OrderDetails sendOrderDetails(@RequestBody OrderDetails orderDetails, Model model){
        model.addAttribute("orderDetails",orderDetails);

        System.out.println("ssss+++"+orderDetails);
        return orderDetails;
    }
}
