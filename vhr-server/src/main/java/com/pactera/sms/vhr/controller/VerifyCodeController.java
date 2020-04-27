package com.pactera.sms.vhr.controller;

import com.pactera.sms.vhr.util.VerifyCodeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName VerifyCodeController
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@RestController
public class VerifyCodeController {
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        VerifyCodeUtils verifyCodeUtils = new VerifyCodeUtils();
        BufferedImage image = verifyCodeUtils.getImage();
        //对应的验正码
        String text = verifyCodeUtils.getText();
        //将验证码存到到session中
        request.getSession().setAttribute("verifyCode", text);
        try {
            VerifyCodeUtils.output(image, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
