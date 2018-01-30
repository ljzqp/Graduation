package com.jxau.kknq.Repository;


import com.jxau.kknq.Entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Users getUsersByTelPhoneAndPassword(String tel,String password);

}
