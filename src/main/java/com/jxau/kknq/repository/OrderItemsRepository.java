package com.jxau.kknq.repository;

import com.jxau.kknq.entity.OrderItems;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/4/8 13:47
 */
@Repository
public interface OrderItemsRepository extends PagingAndSortingRepository<OrderItems,Integer>,
        JpaSpecificationExecutor<OrderItems> {
}
