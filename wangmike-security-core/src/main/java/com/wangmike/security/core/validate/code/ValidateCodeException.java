/**
 * 
 */
package com.wangmike.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 22:45
 *    desc    : 图形验证码异常
 *    version : v1.0
 * </pre>
 */
public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7285211528095468156L;

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
