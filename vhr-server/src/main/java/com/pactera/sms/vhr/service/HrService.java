package com.pactera.sms.vhr.service;

import com.pactera.sms.vhr.entity.Hr;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HrService
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
public interface HrService extends UserDetailsService {
    List<Hr> getAllHrList(String keywords);

    /**
     * 根据hrId删除hr信息
     *
     * @param id
     */
    void deleteHrByHrId(Integer id);

    void updateHr(Hr hr);

    void addHrRoles(Integer hrId, Integer[] rids);

    boolean updateHrPwd(Map pwdMap);
}
