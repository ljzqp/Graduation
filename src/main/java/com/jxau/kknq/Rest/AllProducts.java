package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/7 10:21
 */
@Controller
public class AllProducts {

    @GetMapping(value = "products")
    public String products(){
        return "products";
    }
}
