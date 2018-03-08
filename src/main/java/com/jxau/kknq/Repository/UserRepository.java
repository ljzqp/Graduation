package com.jxau.kknq.repository;


import com.jxau.kknq.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Users getUsersByTelPhoneAndPassword(String tel,String password);

    @Query(value = "FROM Users u WHERE u.username = ?1 AND u.password = ?2")
    Users getUsersByUsername(String username,String password);

    Users getUserByTelPhone(String tel);
    /** 通过邮箱获取对象 */
    Users findByEmail(String email);

//    @Query(value = "INSTER")
//    void register(String username,String password,String birth,String address);
}
