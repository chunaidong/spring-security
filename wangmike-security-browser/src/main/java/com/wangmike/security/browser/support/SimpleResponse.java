package com.wangmike.security.browser.support;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 14:40
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class SimpleResponse {


    public SimpleResponse(Object object){
        this.object = object;
    }

    private Object object;


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
