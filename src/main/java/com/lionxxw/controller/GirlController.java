package com.lionxxw.controller;

import com.lionxxw.bean.Girl;
import com.lionxxw.dao.GirlRepository;
import com.lionxxw.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Package com.lionxxw.controller
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 19:31
 * version 1.0.0
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 新增一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Long id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新女生信息
     * @param id
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Long id, Girl girl){
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Long id){
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 插入2条数据,模拟事务回滚
     */
    @GetMapping(value = "/girls/two")
    public void girlInsertTwo(){
        girlService.insertTwo();
    }
}