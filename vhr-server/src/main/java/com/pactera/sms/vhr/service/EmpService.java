package com.pactera.sms.vhr.service;

import com.pactera.sms.vhr.entity.*;
import com.pactera.sms.vhr.vo.PageResultVo;

import java.util.Date;
import java.util.List;

/**
 * @ClassName EmpService
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
public interface EmpService {
    /**
     * 分页模糊查询员工信息
     *
     * @param emp
     * @param beginDateScope
     * @param page
     * @param size
     * @return
     */
    PageResultVo getEmpList(Emp emp, Date[] beginDateScope, Integer page, Integer size);

    /**
     * 获取所有的职位信息
     *
     * @return
     */
    List<Position> getPositionList();

    /**
     * 获取最新工号
     *
     * @return
     */
    String getMaxWorkID();

    /**
     * 获取职位
     *
     * @return
     */
    List<JobLevel> getJobLevels();

    /**
     * 获取政治面貌
     *
     * @return
     */
    List<PoliticsStatus> getPoliticsStatus();

    /**
     * 获取所有部门
     *
     * @return
     */
    List<Department> getDepartmentList();

    /**
     * 添加员工信息
     *
     * @param emp
     */
    Integer addEmp(Emp emp);

    /**
     * 修改员工信息
     *
     * @param emp
     */
    void updateEmp(Emp emp);

    /**
     * 删除员工信息
     *
     * @param emp
     */
    void deleteEmp(Integer emp);

    List<Nation> getNationList();

    /**
     * 查询所有员工以及对应部门工资账套信息
     *
     * @param page
     * @param size
     * @return
     */
    PageResultVo getEmpListByPageWithSalary(Integer page, Integer size);

    Emp getEmpById(Integer empId);
}
