package com.pactera.sms.vhr.mapper;

import com.pactera.sms.vhr.entity.Hr;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HrMapper
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Component
public interface HrMapper {
    //    @Select("select * from hr where username = #{userName}")
    Hr loadUserByUsername(String userName);

    /**
     * 根据keywords查询出除登录用户外的所有hr及角色信息
     *
     * @param id
     * @param keywords
     * @return
     */
    List<Hr> getAllHrList(@Param("id") Integer id, @Param("keywords") String keywords);

    void deleteHrByHrId(Integer id);

    void updateHrSelective(Hr hr);

    void updateHrPwd(Map pwdMap);

    Hr getHrById(Integer hrId);
}
