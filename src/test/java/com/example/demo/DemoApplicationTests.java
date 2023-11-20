package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserRoleMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.VO.UserRoleVO;
import com.example.demo.entity.VO.UserRoleVO2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    static JsonMapper jsonMapper = new JsonMapper();

    static {
        jsonMapper.registerModule(new JavaTimeModule());
    }

    @Autowired
    UserMapper mapper;
    @Autowired
    UserRoleMapper urMapper;

    @Test
    void add() {
        User user = new User();
        user.setUserName("testAddUser" + System.currentTimeMillis());
        user.setPassword("123456");
        user.setEmail("123456@qq.com");
        Integer i = mapper.insertUser(user);
        System.out.println(i > 0 ? "添加用户成功" : "添加用户失败！");
        System.out.println(user.toString());
    }

    @Test
    void del() {
        Integer i = mapper.deleteUserById(2);
        System.out.println(i > 0 ? "删除用户成功" : "删除用户失败！");
    }

    @Test
    void upt() {
        List<User> users = mapper.listUser();
        User u = users.get(0);
        System.out.println("update before:" + u.toString());
        u.setEmail("uptEmail@qq.com" + System.currentTimeMillis());
        Integer i = mapper.updateUser(u);
        System.out.println(i > 0 ? "更新用户成功" : "更新用户失败！");
        System.out.println("update after:" + u.toString());

    }

    @Test
    void sel() {
        List<User> users = mapper.listUser();
        users.forEach(System.out::println);
    }

    @Test
    void alist() {
        TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();
        // 注册别名包路径
        typeAliasRegistry.registerAliases("com.example.demo.entity");

        // 获取所有已注册的别名
        typeAliasRegistry.getTypeAliases().forEach((alias, clazz) ->
                System.out.println("Alias: " + alias + ", Class: " + clazz.getName())
        );
    }

    @Test
    void getUserRoleVOById() throws JsonProcessingException {
//        一对一
        UserRoleVO vo = urMapper.getUserRoleVOById(1);
        System.out.println(vo);
        System.out.println(jsonMapper.writeValueAsString(vo));
    }

    @Test
    void getUserRoleVoById_one_to_many() throws JsonProcessingException {
        // 一对多, 需要保证id是同一个才能合并roles
        UserRoleVO2 vo = urMapper.getUserRoleVOByUserId(1);
        System.out.println(vo);
        System.out.println(jsonMapper.writeValueAsString(vo));
    }


    @Test
    void getUserRoleVoById_many_to_many() throws JsonProcessingException {
        // 多对多
        List<UserRoleVO2> vo = urMapper.getUserRoleVOByUserId_Allinfo(1);
        System.out.println(vo);
        System.out.println(jsonMapper.writeValueAsString(vo));

    }


}
