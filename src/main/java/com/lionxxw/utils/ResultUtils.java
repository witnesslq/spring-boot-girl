package com.lionxxw.utils;

import com.lionxxw.domain.Result;
import com.lionxxw.enums.ResultEnum;

/**
 * 异常封装工具类
 * Package com.lionxxw.utils
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/3/14 13:53
 * version 1.0.0
 */
public class ResultUtils {
    public static Result getSuccess(Object obj){
        Result result = new Result();
        result.setCode(Result.successCode);
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    public static Result getSuccess(){
        return getSuccess(null);
    }

    public static Result getFail(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result getFail(ResultEnum resultEnum){
        return getFail(resultEnum.getCode(), resultEnum.getMsg());
    }
}
