package com.jxau.kknq.Repository;


import com.jxau.kknq.Entity.Hello;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Hello,Integer> {

}
