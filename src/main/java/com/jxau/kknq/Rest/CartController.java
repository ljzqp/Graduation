package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/26 14:33
 */
@Controller
public class CartController {

    @GetMapping(value = "cart")
    public String cart(){
        return "cart";
    }
}
