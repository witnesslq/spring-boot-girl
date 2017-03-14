package com.lionxxw.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Package com.lionxxw.bean
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 19:23
 * version 1.0.0
 */
@Entity
@Getter
@Setter
public class Girl {
    /**
     * id 自增
     */
    @Id
    @GeneratedValue
    private Long id;
    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内")
    private Integer age;
}
