package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.entity.Salary;
import com.pactera.sms.vhr.service.EmpService;
import com.pactera.sms.vhr.service.SalaryService;
import com.pactera.sms.vhr.vo.PageResultVo;
import com.pactera.sms.vhr.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SalaryController
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/17 0017
 * @Version V1.0
 **/
@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private EmpService empService;

    /**
     * 获取所有账套信息
     */
    @GetMapping("/sob/")
    public List<Salary> getSalaryList() {
        return salaryService.getSalaryList();
    }

    @DeleteMapping("/sob/{id}")
    public String deleteSalarySobById(@PathVariable Integer id) {
        Integer flag = salaryService.deleteSalarySobById(id);
        if (flag == 1) {
            return ResponseVo.ok(200, "删除成功");
        } else {
            return ResponseVo.error(500, "删除失败");
        }
    }

    @GetMapping("/sobcfg/")
    public PageResultVo getEmpListByPageWithSalary(@DefaultValue("1") Integer page, @DefaultValue("10") Integer size) {
        PageResultVo pageResultVo = empService.getEmpListByPageWithSalary(page, size);
        return pageResultVo;
    }

    @GetMapping("/sobcfg/salaries")
    public List<Salary> getAllSalarys() {
        return salaryService.getSalaryList();
    }
    @PutMapping("/sobcfg/")
    public String updateEmpSalary(Integer eid,Integer sid) {
        Integer flag  = salaryService.updateEmpSalary(eid,sid);
        if (flag == 1||flag == 2) {
            return ResponseVo.ok(200, "修改成功");
        } else {
            return ResponseVo.error(500, "修改失败");
        }
    }
}
