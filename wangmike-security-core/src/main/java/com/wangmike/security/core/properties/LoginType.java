package com.wangmike.security.core.properties;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/29 16:13
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public enum LoginType {

    JSON("JSON","登陆成功返回JSON数据"),

    REDIRECT("REDIRECT","登陆成功 重定向到页面");


    private String key;
    private String keyName;

    LoginType(String key,String keyName){
        this.key = key;
        this.keyName = keyName;
    }
    public String getKey() {
        return key;
    }

    public String getKeyName() {
        return keyName;
    }

}
