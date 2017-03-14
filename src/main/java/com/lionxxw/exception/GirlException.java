package com.lionxxw.exception;

import com.lionxxw.enums.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 * Package com.lionxxw.exception
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/3/14 13:43
 * version 1.0.0
 */
public class GirlException extends RuntimeException {
    @Getter
    @Setter
    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}