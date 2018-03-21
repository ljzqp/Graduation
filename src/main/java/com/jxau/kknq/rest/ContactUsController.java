package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/26 14:59
 */
@Controller
public class ContactUsController {

    @GetMapping(value = "contactUs")
    public String contactUs(){
        return "contact-us";
    }
}
