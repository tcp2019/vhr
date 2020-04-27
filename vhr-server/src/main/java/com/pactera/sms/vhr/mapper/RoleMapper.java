package com.pactera.sms.vhr.mapper;

import com.pactera.sms.vhr.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Component
public interface RoleMapper {
    /**
     * 根据hrId查询对应角色
     *
     * @param id
     * @return
     */
//    @Select("select t1.* FROM hr_role t2 LEFT JOIN role t1 on t2.rid = t1.id where t2.hrid =#{id}")
    List<Role> getRolesByHrId(@Param("id") Integer id);

    //    @Select(" SELECT t1.*  FROM menu_role t2  LEFT JOIN role t1 on t2.rid = t1.id where t2.mid =#{id}")
    List<Role> getRolesByMenuId(Integer id);

    void deleteRoleByHrId(Integer hrid);

    void addHrRoles(@Param("hrId") Integer hrId, @Param("rids") Integer[] rids);
}
