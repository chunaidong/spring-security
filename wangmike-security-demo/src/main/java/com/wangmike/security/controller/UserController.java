package com.wangmike.security.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wangmike.security.entity.User;
import com.wangmike.security.entity.UserParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/26 20:54
 *    desc    : 输入描述
 *    version : v1.0
 * </pre>
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/getAuth")
    @ApiOperation("获取当前登陆用户信息")
    public Object getAuth(Authentication authentication){
        return authentication;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation("获取用户列表")
    public List<User> getList(UserParam userParam){
        System.out.println("当前线程【"+Thread.currentThread().getName()+"】");
        System.out.println(userParam);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id}")
    @JsonView(User.UserDetailView.class)
    public User getUser(@PathVariable("id") String id){
        //throw new UserNotExistException(id);
        System.out.println("当前线程【"+Thread.currentThread().getName()+"】");
        System.out.println(id);
        return new User();
    }

    @PostMapping
    @JsonView(User.UserSimpleView.class)
    public User create(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            result.getAllErrors().forEach( error->{
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user.toString());
        user.setId("1");
        user.setUsername("猪小宝");
        return user;
    }

    @PutMapping
    @JsonView(User.UserSimpleView.class)
    public User updateUser(@Valid @RequestBody User user, BindingResult result){
        if (result.hasErrors()){
            result.getAllErrors().forEach( error->{
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user.toString());
        user.setUsername("猪小宝");
        return user;
    }




}
