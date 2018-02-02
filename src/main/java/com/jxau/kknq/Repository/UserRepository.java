package com.jxau.kknq.repository;


import com.jxau.kknq.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Users getUsersByTelPhoneAndPassword(String tel,String password);

    Users getUserByTelPhone(String tel);
    /** 通过邮箱获取对象 */
    Users findByEmail(String email);
}
