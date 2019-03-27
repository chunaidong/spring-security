package com.wangmike.security.validator;

import com.wangmike.security.service.HelloService;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/27 20:22
 *    desc    :自定义校验接口
 *    version : v1.0
 * </pre>
 */
public class MyValidatorClass implements ConstraintValidator<MyValidator,Object> {


    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyValidator constraintAnnotation) {
        System.out.println("init 方法");
    }

    /**
     * 处理校验逻辑
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.sayHello("tom");
        System.out.println(value);
        return false;
    }
}
