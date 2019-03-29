package com.wangmike.security.browser.authentication;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangmike.security.core.properties.LoginType;
import com.wangmike.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 15:48
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Component
public class AuthonticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(AuthonticationSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登陆成功");
        //判断是返回json还是重定向
        if(securityProperties.getBrowser().getLoginType().getKey().equals(LoginType.JSON.getKey())){
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else {
           super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
