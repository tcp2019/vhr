package com.pactera.sms.vhr.service.impl;

import com.pactera.sms.vhr.entity.Salary;
import com.pactera.sms.vhr.mapper.SalaryMapper;
import com.pactera.sms.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalaryServiceImpl
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/17 0017
 * @Version V1.0
 **/
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;
    @Override
    public List<Salary> getSalaryList() {
        return salaryMapper.getSalaryList();
    }

    @Override
    public Integer deleteSalarySobById(Integer id) {
        return salaryMapper.deleteSalarySobById(id);
    }

    @Override
    public Integer updateEmpSalary(Integer eid, Integer sid) {
        return salaryMapper.updateEmpSalary(eid, sid);
    }
}
