package com.jxau.kknq.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/9 17:05
 */
@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue
    @Column(name = "pid")
    private int productId;

    @Column(name = "pimg")
    private String productImgUrl;

    @Column(name = "ptitle")
    private String productTitle;

    @Column(name = "pname")
    private String productName;

    @Column(name = "sugar")
    private int sugar;

    @Column(name = "price")
    private int price;

    //蛋糕分类
    @Column(name = "sort")
    private int type;

    @Column(name = "psmell")
    private  String productSmell;

    @Column(name = "psort")
    private String productSort;

    //材料
    @Column(name = "pmaterial")
    private String productMaterial;
}
