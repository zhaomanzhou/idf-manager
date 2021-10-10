package com.idofast.admin.controller;

import com.idofast.admin.config.context.RequestContext;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.service.SubscriptionService;
import com.idofast.admin.service.UserProxyInfoService;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 4:31 下午
 */

@RestController
@RequestMapping("/subscription")
@Api(tags = "订阅相关的api")
@CrossOrigin
@Slf4j
@Validated
public class SubscriptionController
{

    @Value("${site.enableTls}")
    private Boolean enableTls;

    @Value("${site.host}")
    private String siteHost;

    @Autowired
    private UserProxyInfoService proxyInfoService;

    @Autowired
    private SubscriptionService subscriptionService;


    @RequestMapping("/v2ray/{subscribeCode}")
    @ApiOperation("订阅操作，获取服务器列表")
    public void subscribe(@PathVariable String subscribeCode, HttpServletResponse response) throws BusinessException, IOException
    {
        log.warn("开始获取订阅{}", subscribeCode);
        String subscriptionContent = subscriptionService.getSubscriptionContent(subscribeCode);

        //需要再进行一次base64
        String result = Base64.getEncoder().encodeToString(subscriptionContent.getBytes(StandardCharsets.UTF_8));
        response.setHeader("Content-Length",result.getBytes().length+"");
        response.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.getOutputStream().write(result.getBytes());
        response.flushBuffer();
    }

    @RequestMapping("/url")
    @ApiOperation("获取我的订阅链接")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "type", value = "订阅类型； v2ray", defaultValue = "v2ray")
    )
    public ServerResponse<String> getMySubscriptionUrl(@NotNull String type) throws BusinessException
    {
        if(!type.equals("v2ray")){
            throw new BusinessException("不支持的订阅类型");
        }
        Long id = RequestContext.getCurrentUser().getId();
        UserProxyInfo proxyInfo;
        try
        {
            proxyInfo = proxyInfoService.selectById(id, false);
        } catch (BusinessException e)
        {
            throw new BusinessException("获取订阅链接失败，错误码5200");
        }
        String subscribeCode = proxyInfo.getSubscribeCode();


        String s = getServerUrl() + "/api/subscription/" + type + "/" + subscribeCode;
        return ServerResponse.success(s);


    }


    private String getServerUrl()
    {
        String prefix = enableTls? "https": "http";
        String s = prefix + "://" + siteHost;
        return s;
    }
}
