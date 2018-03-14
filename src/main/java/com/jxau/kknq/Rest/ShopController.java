package com.jxau.kknq.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/26 14:06
 */
@Controller
public class ShopController {

    @GetMapping(value = "shop")
    public String shop(){
        return "shop";
    }
}
