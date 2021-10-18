package com.idofast.admin.config.interceptor;

import com.idofast.admin.constant.TokenHashConst;
import com.idofast.admin.domain.User;
import com.idofast.admin.util.Jwtutil;
import com.idofast.common.redis.RedisPrefixConst;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaomanzhou
 * @date 2020/3/19 10:39 下午
 */

@Component
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${token.expiration}")
    private int expiration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String token = request.getHeader("token");

        if(!Jwtutil.isValidate(token))
        {
            log.warn("没有带token的请求:{}, ip:{}", request.getRequestURL(), request.getRemoteAddr());
            request.getRequestDispatcher("/error/unlogin").forward(request, response);
            return false;
        }
        User user = (User)redisTemplate.opsForHash().get(RedisPrefixConst.TOKEN_PREFIX + token, TokenHashConst.USER);
        if(user == null)
        {
            log.warn("错误的token请求:{}, ip:{}", request.getRequestURL(), request.getRemoteAddr());
            request.getRequestDispatcher("/error/unlogin").forward(request, response);
            return false;
        }else
        {
            redisTemplate.expire(RedisPrefixConst.TOKEN_PREFIX+token, expiration, TimeUnit.MINUTES);
            request.setAttribute("curUser", user);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
