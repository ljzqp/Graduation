package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/8 16:46
 */
@Controller
public class HappinessController {
    @GetMapping(value = "happiness")
    public String getHappiness(){
        return "happiness";
    }
}
