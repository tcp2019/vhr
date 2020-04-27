package com.pactera.sms.vhr.service;

import com.pactera.sms.vhr.entity.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/3 0003
 * @Version V1.0
 **/
public interface RoleService {
    /**
     * 获取所有角色信息
     *
     * @return
     */
    List<Role> getAllRoleList();
}
