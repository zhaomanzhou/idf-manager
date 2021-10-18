package com.idofast.proxy.web.controller;


import com.idofast.common.response.ServerResponse;
import com.idofast.proxy.biz.service.AccountService;
import com.idofast.proxy.service.V2rayService;
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
    private AccountService accountService;

    @Value("${proxy.v2ray.apiPort}")
    private Integer v2rayApiPort;

    @Value("${proxy.v2ray.host}")
    private String host;


    @ResponseBody
    @PostMapping(value = "/account/del")
    public ServerResponse<String> rmAccount(@NonNull String email, @NonNull Long id) {
        log.info("收到删除账号的通知，id:{}, email:{}",id, email);
        try {
            accountService.invalidUser(id);
            v2rayService.rmProxyAccount(host, v2rayApiPort, "6001", email);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除账号出错 :{}", e.getLocalizedMessage());
//            return ServerResponse.error();
        }
        return ServerResponse.success();

    }


}
