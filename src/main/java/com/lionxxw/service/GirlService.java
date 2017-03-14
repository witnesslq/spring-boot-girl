package com.lionxxw.service;

import com.lionxxw.bean.Girl;
import com.lionxxw.dao.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Package com.lionxxw.service
 * Project girl
 * Company www.baofoo.com
 * Author wangjian@baofoo.com
 * Created on 2017/2/27 20:07
 * version 1.0.0
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl a = new Girl();
        a.setAge(18);
        a.setCupSize("A");
        girlRepository.save(a);

        Girl b = new Girl();
        b.setCupSize("G");
        b.setAge(30);
        int i = 1/0;/*模拟异常*/
        girlRepository.save(b);
    }
}
