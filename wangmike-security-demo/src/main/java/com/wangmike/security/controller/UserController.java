package com.wangmike.security.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wangmike.security.entity.User;
import com.wangmike.security.entity.UserParam;
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



    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> getList(UserParam userParam){
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
