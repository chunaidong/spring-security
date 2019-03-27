package com.wangmike.security.entity;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/26 21:06
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class UserParam {


    private String username;

    private int age;

    private int ageTo;

    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return "UserParam{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", ageTo=" + ageTo +
                ", xxx='" + xxx + '\'' +
                '}';
    }
}
