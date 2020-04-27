package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.entity.Hr;
import com.pactera.sms.vhr.service.HrService;
import com.pactera.sms.vhr.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName HrInfoController
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/17 0017
 * @Version V1.0
 **/
@RestController
@RequestMapping("/hr")
public class HrInfoController {
    @Autowired
    private HrService hrService;

    @GetMapping("/info")
    public Hr getHrInfo(Authentication authentication) {
        return (Hr) authentication.getPrincipal();
    }

    @PutMapping("/info")
    public String updateHrInfo(@RequestBody Hr hr, Authentication authentication) {
        hrService.updateHr(hr);
        //更新security中的hr信息
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
        return ResponseVo.ok(200, "修改成功");
    }

    @PutMapping("/pass")
    public String updateHrPwd(@RequestBody Map pwdMap, Authentication authentication) {
        boolean flag = hrService.updateHrPwd(pwdMap);
        if (flag) {
            return ResponseVo.ok(200, "修改成功");
        } else {
            return ResponseVo.ok(500, "旧密码不正确");
        }
    }
}
