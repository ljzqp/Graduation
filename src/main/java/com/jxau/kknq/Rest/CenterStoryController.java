package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/8 16:54
 */
@Controller
public class CenterStoryController {
    @GetMapping(value = "story")
    public String story(){
        return "story";
    }
}
