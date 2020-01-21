package com.centerm.fud_demo.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
        Map<String, Object> attributes = new HashMap<>();
        if (e instanceof UnauthorizedException) {
            attributes.put("code", "1000001");
            attributes.put("msg", "用户无权限");
            mv.addObject("map",attributes);
        } else if (e instanceof UnknownAccountException) {
            attributes.put("code", "1000002");
            attributes.put("msg", "用户名密码错误");
            mv.addObject("map",attributes);
        } else if (e instanceof IncorrectCredentialsException) {
            attributes.put("code", "1000002");
            attributes.put("msg", "用户名密码有误");
            mv.addObject("map",attributes);
        } else if (e instanceof LockedAccountException) {
            attributes.put("code", "1000003");
            attributes.put("msg", "账号已被锁定");
            mv.addObject("map",attributes);
        } else if (e instanceof AuthenticationException) {
            attributes.put("code", "1000004");
            attributes.put("msg", "未输入账户名和密码");
            mv.addObject("map",attributes);
        }else  if (e instanceof UsernameRepeatingException) {
            attributes.put("code", "1000005");
            attributes.put("msg", "注册用户名重复");
            mv.addObject("map",attributes);
        }else if (e instanceof MultiAccountOnlineException) {
            attributes.put("code", "1000006");
            attributes.put("msg", "多账号同时在线异常");
            mv.addObject("map",attributes);
        }else  if (e instanceof SuperVipRemoveAdminException) {
            attributes.put("code", "1000007");
            attributes.put("msg", "superVIP不可以被取消管理员权限");
            mv.addObject("map",attributes);
        }else{
            attributes.put("code", "1000008");
            attributes.put("msg", e.getMessage());
            mv.addObject("map",attributes);
        }
       mv.setViewName("error");
        return mv;
    }
}
