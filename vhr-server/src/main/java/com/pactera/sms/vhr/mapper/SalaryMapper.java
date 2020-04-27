package com.pactera.sms.vhr.mapper;

import com.pactera.sms.vhr.entity.Salary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName SalaryMapper
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/17 0017
 * @Version V1.0
 **/
@Component
public interface SalaryMapper {
    /**
     * 获取所有账套信息
     *
     * @return
     */
    List<Salary> getSalaryList();

    Integer deleteSalarySobById(Integer id);

    Integer updateEmpSalary(@Param("eid") Integer eid, @Param("sid") Integer sid);
}
