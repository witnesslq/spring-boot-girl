package com.lionxxw.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Package com.lionxxw.domain
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/3/14 11:10
 * version 1.0.0
 */
@Getter
@Setter
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 7048898541823620102L;
    private Integer code;       // 状态码: 0-成功,1-失败
    private String msg;         // 提示信息
    private T data;             // 返回数据封装

    public final static int successCode = 0;
    public final static int failCode = 1;
}