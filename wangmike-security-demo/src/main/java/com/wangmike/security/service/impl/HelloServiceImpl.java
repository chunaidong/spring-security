package com.wangmike.security.service.impl;

import com.wangmike.security.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/27 20:22
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String username) {
        System.out.println("hello " + username);
    }
}
