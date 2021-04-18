package com.idofast.admin.config.interceptor;


import com.idofast.common.response.ServerResponse;
import com.idofast.common.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class ProxyApiAuthInterceptor implements HandlerInterceptor {


    @Value("${proxy.authPassword}")
    private String authPassword;

    public static final String AUTH_NAME = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
