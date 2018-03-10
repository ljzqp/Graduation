package com.jxau.kknq.rest;

import com.jxau.kknq.entity.Products;
import com.jxau.kknq.service.ProductsService;
import com.jxau.kknq.util.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/3/7 10:21
 */
@Controller
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @GetMapping(value = "products")
    public String products(){
        return "products";
    }

    @GetMapping(value = "details")
    public String details(){
        return "deteil";
    }

    @RequestMapping(value = "/{type}/cakes", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<List<Products>> getCakesByType(
            @PathVariable("type") int type,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        return productsService.getProductsByType(type,pageNum, pageSize);
    }

    @RequestMapping(value = "/keyWord/cakes", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<List<Products>> searchCakes(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        String keyWord = request.getParameter("keyWord");
        System.out.println("key____________"+keyWord);
        return productsService.getProductsByKeyWord(keyWord,pageNum, pageSize);
    }
}
