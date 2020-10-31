package com.idofast.admin.config.interceptor;

import com.idofast.admin.annotation.AuthRole;
import com.idofast.admin.constant.TokenHashConst;
import com.idofast.admin.domain.User;
import com.idofast.admin.util.Jwtutil;
import com.idofast.common.common.RedisPrefixConst;

import com.idofast.common.enums.RoleEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @date 2020/3/19 10:39 下午
 */
@Slf4j
@Component
public class NeedLoginAnnotationInterceptor extends HandlerInterceptorAdapter
{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${token.expiration}")
    private int expiration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String token = request.getHeader("token");


        if (handler instanceof HandlerMethod)
        {
            HandlerMethod method = (HandlerMethod) handler;

            // 获取方法上有没有打注解
            AuthRole authRole = method.getMethodAnnotation(AuthRole.class);

            // 不为null表示该方法打了注解需要校验是否登录了
            if (authRole != null)
            {

                // 先获取当前请求的请求参数
                String query = StringUtils.isNotEmpty(request.getQueryString()) ? ("?" + request.getQueryString()) : "";

                // 先获取当前请求的请求完整url
                String callBackUrl = request.getRequestURL().toString() + query;
                log.debug("当前请求的url：{}", callBackUrl);
                log.debug("当前请求需要登录后才能请求，开始检验是否登录！");

                User user = validateLogin(token);
                if (user != null)
                {
                    log.debug("校验完毕，用户已登录，开始校验权限");
                    RoleEnum requiredRole = authRole.role();
                    RoleEnum actualRole = user.getRole();
                    if (actualRole.getCode() <= requiredRole.getCode())
                    {
                        request.setAttribute("currentUser", user);
                        log.info("用户{}, 成功访问了{}接口", user.getEmail(), callBackUrl);
                        return true;
                    }else
                    {
                        log.warn("y");
                    }
                }
                log.info("校验完毕，当前没有登录，开始进行重定向");

                // 如果没有登录
                // 校验是否配置了自定义的跳转地址
                String redirectUrl = StringUtils.isNotEmpty(authRole.returnUrl()) ? authRole.returnUrl() : "/user/unlogin";
                log.info("重定向的url：{}", authRole.returnUrl());

                // 自定义的跳转地址不为null那么去做重定向跳转
                response.sendRedirect(authRole.returnUrl());

                return false;
            }
        }


        return true;
    }

    public User validateLogin(String token)
    {
        if (!Jwtutil.isValidate(token))
        {
            log.info("token不合法");
            return null;
        }
        User user = (User) redisTemplate.opsForHash().get(RedisPrefixConst.TOKEN_PREFIX + token, TokenHashConst.USER);
        if (user == null)
        {
            log.info("token已过期");
            return null;
        } else
        {
            redisTemplate.expire(RedisPrefixConst.TOKEN_PREFIX + token, expiration, TimeUnit.MINUTES);
        }
        return user;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        super.postHandle(request, response, handler, modelAndView);
    }

}
