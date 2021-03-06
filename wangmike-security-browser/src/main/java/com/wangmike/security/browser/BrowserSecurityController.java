package com.wangmike.security.browser;

import com.wangmike.security.browser.support.SimpleResponse;

import com.wangmike.security.core.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 14:19
 *    desc    : 输入
 *    version : v1.0
 * </pre>
 */
@RestController
public class BrowserSecurityController {
    private Logger logger = LoggerFactory.getLogger(BrowserSecurityController.class);
    /**
     * 请求缓存，用户发送的请求在进入authentication/require前，会将请求缓存到session中
     */
    private RequestCache requestCache = new HttpSessionRequestCache();
    /**
     * 请求重定向对象
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 当需要身份认证时，跳转到这里
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception{
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(null != savedRequest){
            //获取用户发起的真实请求
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是："+targetUrl);
            //判断是否由html引发的跳转
            if(StringUtils.endsWithIgnoreCase(targetUrl, ".html")){
                //重定向到默认登陆页面
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("您访问的服务需要身份认证，请先登陆");
    }

}
