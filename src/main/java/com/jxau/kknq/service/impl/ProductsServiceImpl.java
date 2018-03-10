package com.jxau.kknq.service.impl;

import com.jxau.kknq.entity.Products;
import com.jxau.kknq.repository.ProductsRepository;
import com.jxau.kknq.service.ProductsService;
import com.jxau.kknq.util.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/9 17:53
 */
@Service("ProductsService")
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public PageResult<List<Products>> getProductsByType(int type, Integer pageNum, Integer pageSize) {
        Pageable pageable = null;
        Page<Products> page;
        List<Products> products;
        int sortMin;
        int sortMax;
        if (pageSize != 0) {
            pageable = new PageRequest(pageNum - 1, pageSize);
        }

        if (type == 0) {
            sortMin = 0;
            sortMax = 4;
            Specification<Products> specification = getSpecification(sortMin, sortMax);
            page = productsRepository.findAll(specification, pageable);

        }
        if (type == 01) {
            sortMin = 5;
            sortMax = 6;
            Specification<Products> specification = getSpecification(sortMin, sortMax);
            page = productsRepository.findAll(specification, pageable);
        }
        else {
            page = productsRepository.getProductsByType(type, pageable);
        }
        if (page == null) {
            return PageResult.FaildPageResult();
        }
        products = page.getContent();
        return PageResult.SuccPageResult(products, page);
    }

    @Override
    public PageResult<List<Products>> getProductsByKeyWord(String keyWord, Integer pageNum, Integer pageSize) {
        Pageable pageable = null;
        Page<Products> page;
        List<Products> products;

        Specification<Products> specification= (root, query, cb) -> {
            Predicate p2 = cb.like(root.get("pname").as(String.class), "%"+keyWord+"%");
            query.where(cb.and(p2));
            return query.getRestriction();
        };
        if (pageSize != 0) {
            pageable = new PageRequest(pageNum - 1, pageSize);
        }
        if (keyWord == null) {
            return PageResult.FaildPageResult();
        }
        page = productsRepository.findAll(specification, pageable);

        products = page.getContent();
        return PageResult.SuccPageResult(products, page);
    }

    //根据商品种类的不同构建查询条件
    private Specification<Products> getSpecification(int sortMin, int sortMax) {
        return (root, query, cb) -> {
            Path<Integer> path = root.get("type");
            return cb.between(path, sortMin, sortMax);
        };
    }

}
