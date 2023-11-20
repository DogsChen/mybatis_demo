package com.example.demo.dao;

import com.example.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    Integer insertRole(Role role);

    Integer deleteRoleById(int id);

    Integer updateRole(Role role);

    Role getRoleById(int id);

    List<Role> listRole();
}
