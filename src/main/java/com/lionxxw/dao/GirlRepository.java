package com.lionxxw.dao;

import com.lionxxw.bean.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Package com.lionxxw.service
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 19:33
 * version 1.0.0
 */
public interface GirlRepository extends JpaRepository<Girl, Long> {
    List<Girl> findByAge(Integer age);
}
