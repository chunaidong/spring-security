package com.wangmike.security.core.properties;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 14:49
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class BrowserProperties {

    /**
     * 如果没有获取到配置，则默认跳转到wangmike-login用户页面
     */
    private String loginPage = "/wangmike-login.html";

    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
