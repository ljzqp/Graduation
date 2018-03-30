package com.jxau.kknq.bean;

import lombok.Data;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/28 18:46
 */
@Data
public class OrderDetails {

    private String productTitle;

    private String productNumber;

    private int price;

    private String others;

    private String orderTime;

    private String orderName;

    private String contact;

    private String address;

    private String deliverWay;

    private String deliverDate;

    private String deliverStartTime;

    private String deliverEndTime;

    private String payWay;


}
