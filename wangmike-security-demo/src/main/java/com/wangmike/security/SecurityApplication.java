package com.wangmike.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/19 21:27
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@SpringBootApplication
@EnableSwagger2
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class,args);
    }

}
