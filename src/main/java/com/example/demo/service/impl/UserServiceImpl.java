package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper mapper;

    @Override
    public List<User> getUsers() {
        return mapper.listUser();
    }

    @Override
    public Integer insertUser(User user) {
        return mapper.insertUser(user);
    }

    @Override
    public Integer deleteUserById(int id) {
        return mapper.deleteUserById(id);
    }

    @Override
    public Integer updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return mapper.getUserById(id);
    }
}
