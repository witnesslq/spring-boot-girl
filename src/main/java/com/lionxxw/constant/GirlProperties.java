package com.lionxxw.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Package com.lionxxw.bean
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 16:50
 * version 1.0.0
 */
@ConfigurationProperties(prefix = "girl")
@Getter
@Setter
@Component
public class GirlProperties {
    private String cupSize;
    private String age;
    public String getContext(){
        return "大家好,我"+age+"岁了,我的罩杯是"+cupSize;
    }
}
