package com.wangmike.security.browser.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangmike.security.browser.support.SimpleResponse;
import com.wangmike.security.core.properties.LoginType;
import com.wangmike.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 15:51
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Component
public class AuthonticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(AuthonticationFailureHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("登陆失败");
        //判断是返回json还是重定向
        if(securityProperties.getBrowser().getLoginType().getKey().equals(LoginType.JSON.getKey())){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
        }else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
