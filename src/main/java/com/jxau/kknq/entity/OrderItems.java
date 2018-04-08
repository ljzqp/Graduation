package com.jxau.kknq.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/28 13:55
 */
@Entity
@Data
@Table(name = "order_items")
public class OrderItems {
    @Id
    @SequenceGenerator(name = "jlsqSeq", sequenceName = "JLSQ_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "jlsqSeq")
    private Integer id;

    //映射多对一的关联关系
    @JoinColumn(name = "order_id") // 关联order表的字段
    @ManyToOne(fetch = FetchType.LAZY)
    private Orders order;
    /**
     * 商品 ID
     */
    @Column(name = "pid")
    private Long productId;
    /**
     * 商品数量
     */
    @Column(name = "productnum")
    private Integer productNum;
    /**
     * 销售单价
     */
    private Float price;
    /**
     * 销售总价
     */
    @Column(name = "total_price")
    private Float totalPrice;
    /**
     * 商品名称
     */
    @Column(name = "pname")
    private String productName;
    /**
     * 商品属性
     */
    @Column(name = "productspec")
    private String productSpec;
    /**
     * 商品大图标URL
     */
    @Column(name = "product_big_img")
    private String productBigImg;
    /**
     * 商品类别id
     */
    @Column(name = "product_category_id")
    private String productCategoryId;
    /**
     * 商品类别名称
     */
    @Column(name = "product_category_name")
    private String productCategoryName;
    /**
     * 使用优惠券金额
     */
    @Column(name = "use_coupon")
    private Float useCoupon =0.0f;
    @Column(name = "orderno_id")
    private Integer orderNoId;
}
