package com.pactera.sms.vhr.service;

import com.pactera.sms.vhr.entity.Salary;

import java.util.List;

/**
 * @ClassName SalaryService
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/17 0017
 * @Version V1.0
 **/
public interface SalaryService {

    List<Salary> getSalaryList();

    Integer deleteSalarySobById(Integer id);

    Integer updateEmpSalary(Integer eid, Integer sid);
}
