package com.pactera.sms.vhr.service.impl;

import com.pactera.sms.vhr.entity.Hr;
import com.pactera.sms.vhr.entity.Menu;
import com.pactera.sms.vhr.mapper.HrMapper;
import com.pactera.sms.vhr.mapper.MenuMapper;
import com.pactera.sms.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private HrMapper hrMapper;

    @Override
    public List<Menu> getMenuList() {
        //获取hrId
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Hr hr = hrMapper.loadUserByUsername(userDetails.getUsername());
        List<Menu> menuList = menuMapper.getMenuListByHrId(hr.getId());
        return menuList;
    }
}
