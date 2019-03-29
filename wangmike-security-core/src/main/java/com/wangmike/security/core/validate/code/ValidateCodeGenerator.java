package com.wangmike.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 23:59
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public interface ValidateCodeGenerator {


    ImageCode generate(ServletWebRequest request);

}
