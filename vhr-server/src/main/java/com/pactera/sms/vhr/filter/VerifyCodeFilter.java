package com.pactera.sms.vhr.filter;

import com.pactera.sms.vhr.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName VerifyCodeFilter
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
@Slf4j
@Component
public class VerifyCodeFilter extends GenericFilter {
    private final Logger logger = LoggerFactory.getLogger(VerifyCodeFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断请求是否是登录请求，并且验证码是否正确
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取请求路径
        String servletPath = request.getServletPath();
        String method = request.getMethod();
        logger.info("请求路径为:{},请求方法为：{}", servletPath, method);
        //是否是登录请求
        if ("POST".equals(method) && "/doLogin".equals(servletPath)) {
            //获取前端填写的验证码
            String code = request.getParameter("code");
            //与session中的验证码对比
            if (!StringUtils.isEmpty(code) &&StringUtils.equalsIgnoreCase(code,(String)request.getSession().getAttribute("verifyCode"))) {
                //验证码正确,放行
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //提示验证码错误
                response.setContentType("application/json;charset=utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(ResponseVo.error(500, "验证码错误"));
                writer.flush();
                writer.close();
                return;
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
