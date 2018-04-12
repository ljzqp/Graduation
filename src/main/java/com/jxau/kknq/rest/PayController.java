package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/12 14:41
 */
@Controller
public class PayController {

    @GetMapping(value = "pay/payNull")
    public String getPayNullPage(){
        return "pay_null";
    }

}
