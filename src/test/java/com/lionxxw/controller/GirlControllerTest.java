package com.lionxxw.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author wangjian@baofoo.com
 * @version 1.0.0
 * @description TODO
 * @package com.lionxxw.controller
 * @project girl
 * @company www.baofoo.com
 * @date 2017/3/14 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk());      // 比较返回状态
        //.andExpect(MockMvcResultMatchers.content().string("test")); // 比较返回内容

    }

    @Test
    public void girlAdd() throws Exception {

    }

    @Test
    public void girlFindOne() throws Exception {

    }

    @Test
    public void girlUpdate() throws Exception {

    }

    @Test
    public void girlDelete() throws Exception {

    }

    @Test
    public void girlFindByAge() throws Exception {

    }

    @Test
    public void girlInsertTwo() throws Exception {

    }

    @Test
    public void getGirlAge() throws Exception {

    }

}