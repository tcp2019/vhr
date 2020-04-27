package com.pactera.sms.vhr.mapper;

import com.pactera.sms.vhr.entity.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MenuMapper
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Component
public interface MenuMapper {
    /**
     * 获取所有的菜单功能
     *
     * @return
     */
    @Select("select * from menu")
    List<Menu> getAllMenu();

//    @Select("select t4.*\n" +
//            "from \n" +
//            "hr_role t1 LEFT JOIN role t2 on t1.rid = t2.id\n" +
//            "LEFT JOIN menu_role t3 on t2.id = t3.rid\n" +
//            "LEFT JOIN menu t4 on t3.mid = t4.id\n" +
//            "where t1.hrid = #{id} ")
    List<Menu> getMenuListByHrId(Integer id);
}
