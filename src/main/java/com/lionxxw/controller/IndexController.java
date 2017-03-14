package com.lionxxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package com.lionxxw.controller
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 17:33
 * version 1.0.0
 */
@Controller
public class IndexController {
    @RequestMapping(value = "")
    public String index(){
        return "index";
    }
}
