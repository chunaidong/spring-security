package com.wangmike.security.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/27 20:19
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@Target({ METHOD, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = MyValidatorClass.class)
public @interface MyValidator {

    String message() default "wangmike 的默认校验";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
