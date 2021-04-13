package com.idofast.proxy.web.interceptor;


import com.idofast.common.response.ServerResponse;
import com.idofast.common.util.JsonUtil;
import com.idofast.proxy.bean.ProxyConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private ProxyConstant proxyConstant;

    private static final String AUTH_NAME = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authPassword = proxyConstant.getAuthPassword();
        String reqAuthPassword = request.getHeader(AUTH_NAME);
        if (!StringUtils.hasLength(reqAuthPassword) || !authPassword.equals(reqAuthPassword)) {
            ServerResponse<Object> error = ServerResponse.error();
            response.setHeader("content-type", "application/json;charset=UTF-8");
            response.getOutputStream().write(JsonUtil.obj2StringPretty(error).getBytes());
            return false;
        }
        return true;
    }



}
