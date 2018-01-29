package com.jxau.kknq.Entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private String userName;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "tel")
    private String telPhone;

    @Column(name = "register_time")
    private Date registerTime;

}
