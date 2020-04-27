package com.pactera.sms.vhr.service.impl;

import com.pactera.sms.vhr.entity.Role;
import com.pactera.sms.vhr.mapper.RoleMapper;
import com.pactera.sms.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/3 0003
 * @Version V1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getAllRoleList() {
        return roleMapper.getRolesByHrId(null);
    }
}
