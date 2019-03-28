package com.wangmike.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 15:33
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .and()
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }
}
