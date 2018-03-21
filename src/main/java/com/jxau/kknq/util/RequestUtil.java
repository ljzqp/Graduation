package com.jxau.kknq.util;

import com.jxau.kknq.Entity.Administrators;
import com.jxau.kknq.Entity.Users;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/2/1 15:01
 */
public class RequestUtil {
    /** 获取登陆的用户 */
    public static Users getAccount(HttpServletRequest request) {
        return (Users) request.getSession().getAttribute("login_account");
    }

    /** 获取管理配置 */
    public static Administrators getAppConfig(HttpServletRequest request) {
        return (Administrators) request.getSession().getAttribute("administrators");
    }

    /** 获取管理员邮箱地址 */
    public static String getAdminEmail(HttpServletRequest request) {
        Administrators admin = getAppConfig(request);
        if(admin!=null) {
            return admin.getEmail()==null?"1915029771@qq.com":admin.getEmail();
        } else {
            return "1915029771@qq.com";
        }
    }

    /** 获取url地址 */
    public static String getCurUrl(HttpServletRequest request) {
        String url = request.getScheme()+"://"+
                request.getServerName()+":"+request.getServerPort();
        return url;
    }
}
