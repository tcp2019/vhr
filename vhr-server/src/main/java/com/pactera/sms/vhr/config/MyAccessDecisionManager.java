package com.pactera.sms.vhr.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @ClassName MyAccessDecisionManager
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/27 0027
 * @Version V1.0
 **/
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     * decide：判断是否有权限决策
     *
     * @param authentication:包含继承UserDetailService所有角色的权限信息(GrantedAuthority)
     * @param o                                                               客户端发起请求的request信息，可强制转换
     * @param collection:                                                     为MyFilterInvocationSecurityMetadataSource 中getAttributes 返回值，判断请求的url是否在menu菜单中，如果在，返回给decide方法
     *                                                                        如果不在，则放行
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        //判断当前用户所对应的角色是否满足当前requestUrl所对应的角色
        for (ConfigAttribute configAttribute : collection) {
            //获取requestUrl对应的所有角色
            String roleName = configAttribute.getAttribute();
            //判断当前角色是否是ROLE_LOGIN
            if ("ROLE_LOGIN".equals(roleName)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录，请登录");
                } else {
                    return;
                }
            }
            //如果当前用户角色有一个角色等于roleName，那么就放行,否则就没有权限访问改requestUrl
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                if (roleName.trim().equals(authority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("无权限访问");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
