package com.wangmike.security.browser;

import com.wangmike.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 添加密码生成规则
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
            //表单登陆
        http.formLogin()
            //自定义登陆页面
            //.loginPage("/wangmike-login.html")
            .loginPage("/authentication/require")
            //告诉spring-security用户用此url自定义登录，登录请求拦截的url,也就是form表单提交时指定的action
            .loginProcessingUrl("/authentication/form")
            .and()
             //请求校验
            .authorizeRequests()
            //告诉spring满足此规则的请求，不需要进行校验，直接放过
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage()).permitAll()
            //所有请求
            .anyRequest()
            //都需要校验
            .authenticated()
            .and()
            //禁用掉csrf功能
            .csrf()
            .disable();
    }
}
