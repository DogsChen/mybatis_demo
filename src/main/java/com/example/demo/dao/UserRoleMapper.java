package com.example.demo.dao;

import com.example.demo.entity.UserRole;
import com.example.demo.entity.VO.UserRoleVO;
import com.example.demo.entity.VO.UserRoleVO2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    // 插入用户角色关系
    void insertUserRole(UserRole userRole);

    // 删除用户角色关系 by ID
    void deleteUserRoleById(Integer id);

    // 更新用户角色关系
    void updateUserRole(UserRole userRole);

    // 查询用户角色关系 by ID
    UserRole getUserRoleById(Integer id);

    UserRoleVO getUserRoleVOById(Integer id);

    UserRoleVO2 getUserRoleVOByUserId(Integer id);

    List<UserRoleVO2> getUserRoleVOByUserId_Allinfo(Integer id);
}
