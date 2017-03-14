package com.lionxxw.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * http请求切面
 * Package com.lionxxw.aspect
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/3/14 10:19
 * version 1.0.0
 */
@Aspect
@Component
public class HttpAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private long startTime;
    private long endTime;

    @Pointcut("execution(public * com.lionxxw.controller.*.*(..))")
    public void log (){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("-------------before-------------------");
        startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("getRequestURI:"+request.getRequestURI());
        logger.info("getRequestURL:"+request.getRequestURL());
        logger.info("getContextPath:"+request.getContextPath());
        logger.info("getServletPath:"+request.getServletPath());
        logger.info("getQueryString:"+request.getQueryString());
        // method
        logger.info("method:"+request.getMethod());
        // ip
        logger.info("ip:"+request.getRemoteAddr());
        // 类方法
        logger.info("class_method:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 参数
        logger.info("args:"+ Arrays.asList(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfter(){
        endTime = System.currentTimeMillis();
        logger.info("-------------共花费时间:"+(endTime-startTime)+"ms-------------------");
    }

    @AfterReturning(pointcut = "log()", returning = "obj")
    public void doAfterReturning(Object obj){
        logger.info("response:"+ JSON.toJSONString(obj));
    }
}
