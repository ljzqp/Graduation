package com.jxau.kknq.Entity.aspect;

import groovy.util.logging.Commons;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author luowenbin
 * @email luowenbin@hey900.com
 * @date 2018/1/25 19:35
 */
@Aspect
@Commons
public class HttpAspect {

//    private final static Logger = LoggerFactory.getLogger(HttpAspect.class);
    //@Before注解是在执行指定方法前执行log()，addUser(..)指不管参数是什么都进行拦截
    @Before("execution(public * com.jxau.kknq.Entity.controller.Rest.User.addUser(..))")
    public void before(){
        System.out.println("11111");
    }

    //
    @Pointcut("execution(public * com.jxau.kknq.Entity.controller.Rest.User.addUser(..))")
    public void point(){
        System.out.println("2222");
    }

    // 将point()织入进after()
    @After("point()")
    public void after(){
        System.out.println("11111");
    }
}
