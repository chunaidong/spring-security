package com.wangmike.security.core;

import com.wangmike.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 15:01
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Configuration
//使自定义配置器生效
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
