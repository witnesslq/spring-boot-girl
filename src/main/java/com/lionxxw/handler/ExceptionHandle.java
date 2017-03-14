package com.lionxxw.handler;

import com.lionxxw.domain.Result;
import com.lionxxw.enums.ResultEnum;
import com.lionxxw.exception.GirlException;
import com.lionxxw.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * 统一异常处理
 * Package com.lionxxw.handler
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/3/14 14:24
 * version 1.0.0
 */
@ControllerAdvice
public class ExceptionHandle {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if (e instanceof GirlException){
            GirlException ge = (GirlException) e;
            return ResultUtils.getFail(ge.getCode(), ge.getMessage());
        }else{
            logger.error("【系统异常】{}", e);
            return ResultUtils.getFail(ResultEnum.UNKONW_ERROR);
        }
    }
}