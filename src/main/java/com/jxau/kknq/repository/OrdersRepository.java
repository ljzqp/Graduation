package com.jxau.kknq.repository;

import com.jxau.kknq.entity.Orders;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/8 11:29
 */
@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Orders,Integer>,
        JpaSpecificationExecutor<Orders> {
}
