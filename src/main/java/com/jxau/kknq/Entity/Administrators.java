package com.jxau.kknq.Entity;

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
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/1/29 15:33
 */
@Data
@Entity
public class Administrators {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "age")
    private int age;

    @Column(name = "tel")
    private String telPhone;

    @Column(name = "email")
    private String email;

    /**
     * 管理员状态：0：普通管理员，拥有除删除用户外所有管理权
     *            1：超级管理员，包括删除用户在内所有管理权
     */
    @Column(name = "status")
    @Value("0")
    private int status;

    @Column(name="sex")
    private String sex;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
}
