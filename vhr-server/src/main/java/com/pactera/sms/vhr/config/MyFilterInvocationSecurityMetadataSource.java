package com.pactera.sms.vhr.config;

import com.pactera.sms.vhr.entity.Menu;
import com.pactera.sms.vhr.entity.Role;
import com.pactera.sms.vhr.mapper.MenuMapper;
import com.pactera.sms.vhr.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName MyFilterInvocationSecurityMetadataSource
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/27 0027
 * @Version V1.0
 **/
@Slf4j
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        log.info("拦截到请求url为:{}", requestUrl);
        //将此url与数据库url比对，如果相同，将赋予对应的角色
        //获取所有角色以及菜单功能
        List<Menu> menuList = menuMapper.getAllMenu();
        for (Menu menu : menuList) {
            String url = menu.getUrl();
            if (antPathMatcher.match(url, requestUrl)) {
                //根据menu id获取所角色
                List<Role> roleList = roleMapper.getRolesByMenuId(menu.getId());
                String[] roleNames = new String[roleList.size()];
                for (int i = 0; i < roleList.size(); i++) {
                    roleNames[i] = roleList.get(i).getName();
                }
                return SecurityConfig.createList(roleNames);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
