package com.wangmike.security.core.validate.code;

import com.wangmike.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 22:45
 *    desc    : 图形验证码控制器
 *    version : v1.0
 * </pre>
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY="SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();


    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;


    /**
     * 生成图形验证码
     *   1. 根据随机数生成图片
     *   2. 将随机数存到Session中
     *   3. 在将生存的图片写到接口的响应中
     * @param request
     * @param response
     */
    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
          //TODO 1. 根据随机数生成图片
          ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(request));
          //TODO 2. 将随机数存到Session中
          sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
          //TODO 3. 在将生存的图片写到接口的响应中
          ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }





}
