package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.entity.Hr;
import com.pactera.sms.vhr.entity.Role;
import com.pactera.sms.vhr.service.HrService;
import com.pactera.sms.vhr.service.RoleService;
import com.pactera.sms.vhr.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName HrController
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    private HrService hrService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrList(String keywords) {

        List<Hr> hrList = hrService.getAllHrList(keywords);
        return hrList;
    }

    @GetMapping("/roles")
    public List<Role> getAllRoleList() {
        return roleService.getAllRoleList();
    }

    @DeleteMapping("/{id}")
    public String deleteHrByHrId(@PathVariable Integer id) {
        hrService.deleteHrByHrId(id);
        return ResponseVo.ok(200, "删除成功");
    }

    /**
     * 更新Hr信息
     *
     * @param hr
     * @return
     */
    @PutMapping("/")
    public String updateHr(@RequestBody Hr hr, Authentication authentication) {
        hrService.updateHr(hr);
        return ResponseVo.ok(200, "更新成功");
    }

    /**
     * 为对应的hr赋予角色
     *
     * @param hrid
     * @param rids
     * @return
     */
    @PutMapping("/role")
    public String addHrRoles(Integer hrid, Integer[] rids) {
        hrService.addHrRoles(hrid, rids);
        return ResponseVo.ok(200, "赋予角色成功");
    }
}
