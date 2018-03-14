package com.jxau.kknq.Rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/26 14:05
 */
@Controller
public class AboutUsController {

    @RequestMapping(value = "/aboutUs" , method = RequestMethod.GET)
    public String aboutUs(){
        return  "about-us";
    }

}
