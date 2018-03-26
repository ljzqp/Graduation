package com.jxau.kknq.repository;


import com.jxau.kknq.entity.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/9 17:54
 */
@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products,Integer>,
        JpaSpecificationExecutor<Products> {

    @Query(value = "FROM Products p WHERE p.type = ?1")
    Page<Products> getProductsByType(int type, Pageable pageable);

    @Query(value = "FROM Products p WHERE p.type = ?1")
    Page<Products> searchProductsByKeyWord(String keyWord, Pageable pageable);

    Products getProductsByProductId(int pid);

}
