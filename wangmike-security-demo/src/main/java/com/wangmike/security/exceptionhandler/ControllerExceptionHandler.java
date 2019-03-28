package com.wangmike.security.exceptionhandler;

import com.wangmike.security.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 10:44
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@ControllerAdvice
public class ControllerExceptionHandler {




    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("id", ex.getId());
        map.put("message",ex.getMessage());
        return map;
    }


}
