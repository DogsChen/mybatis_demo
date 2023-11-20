package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService usvc;

    @PostConstruct
    void init() {
//        TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
//        // 注册别名包路径
//        typeAliasRegistry.registerAliases("com.example.demo.entity");
//
//        // 获取所有已注册的别名
//        typeAliasRegistry.getTypeAliases().forEach((alias, clazz) ->
//                System.out.println("Alias: " + alias + ", Class: " + clazz.getName())
//        );
    }


    @GetMapping("/")
    public String index() {
        System.out.println("index");
        return "hello world！";
    }

    @GetMapping("getUsers")
    public void test() {
        System.out.println("test");
        List<User> users = usvc.getUsers();
        users.forEach(System.out::println);
    }

}
