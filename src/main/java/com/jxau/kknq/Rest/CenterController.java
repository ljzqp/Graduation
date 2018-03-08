package com.jxau.kknq.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/8 17:05
 */
@Controller
public class CenterController {

    @GetMapping(value = "center")
    public String getCenterIndex() {
        return "center";
    }

    @GetMapping(value = "vip/activities")
    public String getVipActivities() {
        return "vip-home";
    }

    @GetMapping(value = "vip/application")
    public String getVipApplication() {
        return "vip-home2";
    }

    @GetMapping(value = "vip/diy")
    public String getVipDiy() {
        return "vip-home3";
    }

    @GetMapping(value = "vip/details")
    public String getVipDetails() {
        return "centerPerson";
    }

    @GetMapping(value = "vip/orders")
    public String getVipOrders() {
        return "centerOrder";
    }

    @GetMapping(value = "vip/score")
    public String getVipScore() {
        return "centerScore";
    }

    @GetMapping(value = "vip/information")
    public String getVipInformation() {
        return "centerVip";
    }

    @GetMapping(value = "vip/money")
    public String getVipMoney() {
        return "centerMoney";
    }

    @GetMapping(value = "vip/recharge")
    public String getVipRecharge() {
        return "centerRecharge";
    }

    @GetMapping(value = "vip/voucher")
    public String getVipVoucher() {
        return "centerVoucher";
    }

    @GetMapping(value = "vip/location")
    public String getVipLocation() {
        return "centerLocation";
    }

    @GetMapping(value = "vip/date")
    public String getVipDate() {
        return "centerDate";
    }

    @GetMapping(value = "vip/findpsd")
    public String getFindPassword() {
        return "centerPwd";
    }

    @GetMapping(value = "vip/stroy")
    public String getVipStory() {
        return "centerStroy";
    }

    @GetMapping(value = "vip/upload")
    public String getVipUpload() {
        return "upload";
    }

}
