package com.jxau.kknq.service;

import com.jxau.kknq.entity.Products;
import com.jxau.kknq.util.PageResult;

import java.util.List;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/9 17:39
 */
public interface ProductsService {

    PageResult<List<Products>> getProductsByType(int type, Integer pageNum, Integer pageSize);

    PageResult<List<Products>> getProductsByKeyWord(String keyWord, Integer pageNum, Integer pageSize);

    Products getProductById(int pid);
}
