package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    Integer insertUser(User user);

    Integer deleteUserById(int id);

    Integer updateUser(User user);

    User getUserById(int id);

    List<User> listUser();
}
