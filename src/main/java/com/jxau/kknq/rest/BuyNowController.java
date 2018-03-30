package com.jxau.kknq.rest;

import com.jxau.kknq.bean.OrderDetails;
import com.jxau.kknq.entity.Products;
import com.jxau.kknq.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/22 15:29
 */
@Controller
public class BuyNowController {

    @Autowired
    ProductsService productsService;

    @GetMapping(value = "buynow")
    public String details(){
        System.out.println("fefefefe+");
        return "pay";
    }

    @ResponseBody
    @GetMapping(value = "/buynow/getCakes")
    public Products buyNow(Model model,@RequestParam("pid") int pid){
        System.out.println("aaaaa+"+pid);
        model.addAttribute("orderDetails",new OrderDetails());
        return productsService.getProductById(pid);
    }

}
