package com.wangmike.security.browser;

import com.wangmike.security.browser.authentication.AuthonticationFailureHandler;
import com.wangmike.security.browser.authentication.AuthonticationSuccessHandler;
import com.wangmike.security.core.properties.SecurityProperties;
import com.wangmike.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

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

    @Autowired
    private AuthonticationFailureHandler authonticationFailureHandler;

    @Autowired
    private AuthonticationSuccessHandler authonticationSuccessHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 记住我功能使用
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
       // tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

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
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(authonticationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();
            //在UsernamePasswordAuthenticationFilter之前添加图形验证码校验
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            //表单登陆
            .formLogin()
            //自定义登陆页面
            //.loginPage("/wangmike-login.html")
            .loginPage("/authentication/require")
            //告诉spring-security用户用此url自定义登录，登录请求拦截的url,也就是form表单提交时指定的action
            .loginProcessingUrl("/authentication/form")
            //自定义登陆成功处理器
            .successHandler(authonticationSuccessHandler)
            //自定义登陆失败处理器
            .failureHandler(authonticationFailureHandler)
            .and()
            //记住我功能
            .rememberMe()
            //获取token方式
            .tokenRepository(persistentTokenRepository())
            //token失效时间
            .tokenValiditySeconds(securityProperties.getBrowser().getRememberSeconds())
            //获取token之后的用户信息
            .userDetailsService(userDetailsService)
            .and()
             //请求校验
            .authorizeRequests()
            //告诉spring满足此规则的请求，不需要进行校验，直接放过
            .antMatchers("/authentication/require",
                    securityProperties.getBrowser().getLoginPage(),
                    "/code/image").permitAll()
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
