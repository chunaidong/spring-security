package com.wangmike.security.controller;

import cn.hutool.json.JSONUtil;
import com.wangmike.security.entity.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/26 20:38
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenQuerySuccess() throws Exception{
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .param("username", "wangmike")
                .param("age", "10")
                .param("ageTo", "35")
                .param("xxx", "sss")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);

    }

    @Test
    public void whenGenInfoSuccess() throws Exception{
        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void whenCreateSuccess() throws Exception{

        Date date = new Date();
        Long time = date.getTime();

        String content = "{\"username\":null,\"password\":null,\"birthDay\":"+time+"}";

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);

        User user = JSONUtil.toBean(contentAsString,User.class);
        System.out.println(user);
    }

    @Test
    public void whenUpdateSuccess() throws Exception{

        Date date = new Date();
        Long time = date.getTime();

        String content = "{\"id\":1,\"username\":\"wangmike\",\"password\":null,\"birthDay\":"+time+"}";

        String contentAsString = mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);

        User user = JSONUtil.toBean(contentAsString,User.class);
        System.out.println(user);
    }
















}
