package com.wangmike.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/19 21:29
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@RestController
@RequestMapping("/security")
public class HelloSecurityController {

    @GetMapping("/helloNoSecurity")
    public String sayHelloFromNoSecurity(){
        return "hello no Securtiy";
    }

}
