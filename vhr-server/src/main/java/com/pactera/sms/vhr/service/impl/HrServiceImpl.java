package com.pactera.sms.vhr.service.impl;

import com.pactera.sms.vhr.entity.Hr;
import com.pactera.sms.vhr.mapper.HrMapper;
import com.pactera.sms.vhr.mapper.RoleMapper;
import com.pactera.sms.vhr.service.HrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HrServiceImpl
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Service
@Slf4j
public class HrServiceImpl implements HrService {
    @Autowired
    private HrMapper hrMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Hr> getAllHrList(String keywords) {
        if (keywords == null) {
            keywords = "";
        }
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return hrMapper.getAllHrList(hr.getId(), keywords);
    }

    /**
     * 为角色授权
     *
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //根据用户名查询对应角色
        Hr hr = hrMapper.loadUserByUsername(userName);
        if (hr != null) {
            hr.setRoles(roleMapper.getRolesByHrId(hr.getId()));
            return hr;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }

    @Override
    public void deleteHrByHrId(Integer id) {
        hrMapper.deleteHrByHrId(id);
    }

    @Override
    public void updateHr(Hr hr) {
        if (StringUtils.isNotEmpty(hr.getPassword())) {
            //对密码进行加密
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String newPassword = passwordEncoder.encode(hr.getPassword());
            log.info("加密后的密码为:{}", newPassword);
            hr.setPassword(newPassword);
        }
        hrMapper.updateHrSelective(hr);
    }

    @Override
    public void addHrRoles(Integer hrId, Integer[] rids) {
        //删除掉原有hr的角色
        roleMapper.deleteRoleByHrId(hrId);
        //添加角色
        roleMapper.addHrRoles(hrId, rids);
    }

    @Override
    public boolean updateHrPwd(Map pwdMap) {
        String oldPwd = (String) pwdMap.get("oldpass");
        String checkPwd = (String) pwdMap.get("checkpass");
        String newPwd = (String) pwdMap.get("pass");
        Integer hrId = (Integer) pwdMap.get("hrId");
        Hr hr = hrMapper.getHrById(hrId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Hr hr1 = new Hr();
        hr1.setId(hr.getId());
        if (encoder.matches(oldPwd, hr.getPassword())) {
            hr1.setPassword(encoder.encode(newPwd));
            hrMapper.updateHrSelective(hr1);
            return true;
        } else {
            return false;
        }
    }
}
