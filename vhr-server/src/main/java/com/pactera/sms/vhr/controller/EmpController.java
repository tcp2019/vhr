package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.entity.*;
import com.pactera.sms.vhr.service.EmpService;
import com.pactera.sms.vhr.util.POIUtils;
import com.pactera.sms.vhr.vo.PageResultVo;
import com.pactera.sms.vhr.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * @ClassName EmpController
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/30 0030
 * @Version V1.0
 **/
@RestController
@RequestMapping("/employee/basic")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页模糊查询
     *
     * @param emp
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/")
    public PageResultVo getEmpList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Emp emp, Date[] beginDateScope) {
        return empService.getEmpList(emp, beginDateScope, page, size);
    }

    @GetMapping("/positions")
    public List<Position> getPositionsList() {
        return empService.getPositionList();
    }

    @GetMapping("/nations")
    public List<Nation> getNationList() {
        return empService.getNationList();
    }

    @GetMapping("/maxWorkID")
    public String getMaxWorkID() {

        String maxWorkID = empService.getMaxWorkID();
        return ResponseVo.ok(200, "成功", maxWorkID);
    }

    @GetMapping("/joblevels")
    public List<JobLevel> getJobLevels() {
        return empService.getJobLevels();
    }

    @GetMapping("/politicsStatus")
    public List<PoliticsStatus> getPoliticsStatus() {
        return empService.getPoliticsStatus();
    }

    @GetMapping("/deps")
    public List<Department> getDepartmentList() {
        return empService.getDepartmentList();
    }

    @PostMapping("/")
    public String addEmp(@RequestBody Emp emp) {
        empService.addEmp(emp);
        return ResponseVo.ok(200, "添加成功");
    }

    @PutMapping("/")
    public String pdateEmp(@RequestBody Emp emp) {
        empService.updateEmp(emp);
        return ResponseVo.ok(200, "修改成功");
    }

    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        empService.deleteEmp(id);
        return ResponseVo.ok(200, "删除成功");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> export() {
        PageResultVo empList = getEmpList(1, 10, new Emp(), null);
        List<Emp> empListData = (List<Emp>) empList.getData();
        ResponseEntity<byte[]> responseEntity = POIUtils.Emp2Excel(empListData);
        return responseEntity;
    }

    @PostMapping("/import")
    public String importExcelFile(@RequestParam("file") MultipartFile multipartFile) {
        List<Emp> empList = POIUtils.excel2Emp(multipartFile, getNationList(), getPoliticsStatus(), getDepartmentList(), getPositionsList(), getJobLevels());
        int sum = 0;
        for (Emp emp : empList) {
            Integer successNum = empService.addEmp(emp);
            sum += successNum;
        }
        if (sum == empList.size()) {
            return ResponseVo.ok(200, "上传成功");
        } else {
            return ResponseVo.ok(200, "上传失败");
        }
    }

}
