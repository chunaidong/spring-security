package com.wangmike.security.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.wangmike.security.validator.MyValidator;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/26 20:55
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
public class User {

    public interface UserSimpleView{}

    public interface UserDetailView extends UserSimpleView{}

    @MyValidator(message = "ttttttt")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private String id;

    private Date birthDay;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonView(UserSimpleView.class)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
