package com.jxau.kknq.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hello {

    // 测试提交1
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Integer age;

    public Hello() {
    }
}
