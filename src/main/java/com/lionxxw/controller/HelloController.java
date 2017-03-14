package com.lionxxw.controller;

import com.lionxxw.constant.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Package com.lionxxw.controller
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 16:07
 * version 1.0.0
 */
@RestController
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"hello/{name}","hi/{name}"}, method = RequestMethod.GET)
    public String sayHello(){
        return "hello spring boot";
    }

    @RequestMapping(value = "context", method = RequestMethod.GET)
    public String context(){
        return girlProperties.getContext();
    }

    @RequestMapping(value = "say/{name}",method = RequestMethod.GET)
    public String say(@PathVariable String name){
        return "say="+name;
    }

    @RequestMapping(value = "uuid", method = RequestMethod.GET)
    public String uuid(@RequestParam("id") Long id){
        return "id="+id;
    }
}
