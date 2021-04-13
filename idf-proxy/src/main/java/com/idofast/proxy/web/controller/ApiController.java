package com.idofast.proxy.web.controller;


import com.idofast.common.response.ServerResponse;
import com.idofast.proxy.service.V2rayService;
import com.idofast.proxy.web.adapter.ProxyAccountAdapt;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/proxy/api")
public class ApiController {
    @Autowired
    private V2rayService v2rayService;

    @Autowired
    private ProxyAccountAdapt proxyAccountService;

    @Value("${proxy.v2ray.apiPort}")
    private Integer v2rayApiPort;


    @ResponseBody
    @PostMapping(value = "/account/del")
    public ServerResponse<String> rmAccount(@NonNull String email) {
        try {
//            String accountNo = proxyAccount.getAccountNo();
//            proxyAccountService.rmProxyAccountCache(accountNo,proxyAccount.getHost());
            v2rayService.rmProxyAccount( v2rayApiPort, email);
        } catch (Exception e) {
            log.error("删除账号出错 :{}", e.getLocalizedMessage());
            return ServerResponse.error();
        }
        return ServerResponse.success();

    }


}
