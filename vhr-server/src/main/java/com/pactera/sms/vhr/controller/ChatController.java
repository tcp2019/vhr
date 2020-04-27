package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.entity.Hr;
import com.pactera.sms.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName ChatController
 * @Description: TODO
 * @Author TCP
 * @Date 2020/4/20 0020
 * @Version V1.0
 **/
@RequestMapping("/chat")
@RestController
public class ChatController {
    @Autowired
    private HrService hrService;

    @GetMapping("/hrs")
    public List<Hr> getAllHrExceptCurrentHr() {
        return hrService.getAllHrList(null);
    }
}
