package com.jxau.kknq.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/28 10:50
 */
@Data
@Table(name = "orders")
@Entity
public class Orders {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;
    /**
     * 订单总金额
     */
    private Float amount;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 蛋糕标题
     */
    private String productTitle;
    /**
     * 联系电话
     */
    @Column(name = "contact_tel")
    private String contactTel;
    /**
     * 状态
     * 0-完成；1-已确认；2-已发货；3-已收货；4-已支付
     * 5-已退货；6-已取消；7-待付款；8-下单成功；9-取消中
     */
    private int status;
    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private int productId;
    /**
     * 订单商品数量
     */
    @Column(name = "product_number")
    private int productNumber;
    /**
     * 下单时间
     */
    @Column(name = "ordertime")
    private String orderTime;
    /**
     * 送货地址
     */
    private String address;
    /**
     * 支付方式 0-支付宝支付；1-银联；2-货到付款（现金）；3-会员资金账户；4-使用代金券
     */
    @Column(name = "buy_way")
    private Integer buyWay;
    /**
     * 订单应付金额
     */
    @Column(name = "pay_amount")
    private Float payAmount;
    /**
     * 配送时间
     */
    @Column(name = "deliver_time")
    private String deliverTime;
    /**
     * 使用优惠券金额
     */
    @Column(name = "use_coupon")
    private Float useCoupon = 0.0f;
    /**
     * 备注,留言说明
     */
    @Column(name = "remarks")
    private String remarks;
    /**
     * 配送方式 0-到店自提；1-员工配送；
     */
    @Column(name = "deliver_type")
    private Integer deliverType;
    /**
     * 配送者用户 ID，默认为10086
     */
    @Column(name = "deliver_man_id")
    private Integer deliverManId =10086;
    /**
     * 派送完成时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_time")
    private Date finishTime;
    /**
     * 派送起始时间
     */
    @Column(name = "start_time")
    private String deliverStartTime;
    /**
     * 派送结束时间
     */
    @Column(name = "end_time")
    private String deliverEndTime;
    /**
     * 付款时间
     */
    @Column(name = "pay_time")
    private Date payTime;
    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
}
