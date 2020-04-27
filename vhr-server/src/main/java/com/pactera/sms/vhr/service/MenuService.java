package com.pactera.sms.vhr.service;

import com.pactera.sms.vhr.entity.Menu;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
public interface MenuService {
    /**
     * 根据HrId查询对应所有的Menu集合
     *
     * @return
     */
     List<Menu> getMenuList();
}
