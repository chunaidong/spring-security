package com.wangmike.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 14:50
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@ConfigurationProperties(prefix = "wangmike.security")
public class SecurityProperties {


    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();


    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
