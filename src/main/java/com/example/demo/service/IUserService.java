package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    Integer insertUser(User user);

    Integer deleteUserById(int id);

    Integer updateUser(User user);

    User getUserById(int id);

}
