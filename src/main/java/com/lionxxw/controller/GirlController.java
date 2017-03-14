package com.lionxxw.controller;

import com.lionxxw.bean.Girl;
import com.lionxxw.dao.GirlRepository;
import com.lionxxw.domain.Result;
import com.lionxxw.service.GirlService;
import com.lionxxw.utils.ResultUtils;
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
    public Result<List<Girl>> girlList(){
        return ResultUtils.getSuccess(girlRepository.findAll());
    }

    /**
     * 新增一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtils.getFail(-1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.getSuccess(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Result<Girl> girlFindOne(@PathVariable("id") Long id){
        return ResultUtils.getSuccess(girlRepository.findOne(id));
    }

    /**
     * 更新女生信息
     * @param id
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls/{id}")
    public Result<Girl> girlUpdate(@PathVariable("id") Long id, Girl girl){
        girl.setId(id);
        return ResultUtils.getSuccess(girlRepository.save(girl));
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
    public Result<List<Girl>> girlFindByAge(@PathVariable("age") Integer age){
        return ResultUtils.getSuccess(girlRepository.findByAge(age));
    }

    /**
     * 插入2条数据,模拟事务回滚
     */
    @GetMapping(value = "/girls/two")
    public void girlInsertTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public Result<Girl> getGirlAge(@PathVariable("id") Long id) throws Exception{
        Girl girl = girlService.getGirlAge(id);
        return ResultUtils.getSuccess(girl);
    }
}