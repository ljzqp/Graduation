package com.jxau.kknq.rest;

import com.jxau.kknq.bean.UsersDetails;
import com.jxau.kknq.entity.Users;
import com.jxau.kknq.repository.CenterRepository;
import com.jxau.kknq.entity.Result;
import com.jxau.kknq.service.CenterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/8 17:05
 */
@Controller
public class CenterController {

    @Autowired
    CenterRepository centerRepository;
    @Autowired
    CenterService centerService;

    @GetMapping(value = "center")
    public String getCenterIndex(HttpSession session) {
        if(session.getAttribute("username") == null){
        }
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

    @GetMapping(value = "vip/story")
    public String getVipStory() {
        return "centerStroy";
    }

    @GetMapping(value = "vip/upload")
    public String getVipUpload() {
        return "upload";
    }



    @GetMapping(value = "/modify/userfile")
    @ResponseBody
    public Result modifyMyFile(@RequestBody Users users, Model model, HttpSession session){
        System.out.println("modifyMyFile");
        model.addAttribute("users",users);
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        System.out.println(users);
        try {
            centerRepository.updateUsers(users,username);
            return new Result(100);
        }catch (Exception e){
            return new Result(200);
        }
    }

    @PostMapping(value = "modify/pwd")
    @ResponseBody
    public Result modifyPwd(@RequestBody UsersDetails usersDetails, Model model, HttpSession session){
        System.out.println("modifyPwd");
        model.addAttribute("usersDetails",usersDetails);
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        System.out.println(usersDetails);
        int code = centerService.setNewPassword(usersDetails,username);
        System.out.println(code);
        return new Result(code);
    }


}
