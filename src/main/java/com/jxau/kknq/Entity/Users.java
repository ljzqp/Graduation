package com.jxau.kknq.entity;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Author:zhongqiuping
 * Time:2018/1/28 15:22
 * Description: 网站用户实体类
 */
@Data
@Entity
public class Users {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    /**
     * 注册类型：0：手机号码注册 1：邮箱注册
     */
    @Column(name = "register_type")
    private int registerType;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String telPhone;

    /**
     * 用户状态：0：有效用户 1：无效用户
     */
    @Column(name = "status")
    @Value("0")
    private int status;

    @Column(name="sex")
    private String sex;

    @Column(name="birth")
    private String birthday;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_time")
    private Date registerTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;

}
