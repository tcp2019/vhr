package com.pactera.sms.vhr.mapper;

import com.pactera.sms.vhr.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @ClassName EmpMapper
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@Component
public interface EmpMapper {
    List<Emp> getEmpList(@Param("emp") Emp emp, @Param("beginDateScope") Date[] beginDateScope, @Param("page") int page, @Param("size") int size);

    Long getCount(@Param("emp") Emp emp, @Param("beginDateScope") Date[] beginDateScope);

    List<Position> getPositionList();

    String getMaxWorkID();

    List<JobLevel> getJobLevels();

    List<PoliticsStatus> getPoliticsStatus();

    List<Department> getDepartmentList();

    Integer insertSelective(Emp emp);

    void updateSelective(Emp emp);

    void deleteEmp(Integer id);

    List<Nation> getNationList();

    List<Emp> getEmpListByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Emp getEmpById(Integer empId);
}
