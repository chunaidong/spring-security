package com.wangmike.security.browser;

import com.wangmike.security.filter.TimeFilter;
import com.wangmike.security.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 11:25
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Configuration
public class Configure extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeInterceptor timeInterceptor;


    /**
     *添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 注册第三方过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean() ;

        TimeFilter timeFilter = new TimeFilter();
        filterRegistration.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");

        filterRegistration.setUrlPatterns(urls);


        return filterRegistration;
    }


}
