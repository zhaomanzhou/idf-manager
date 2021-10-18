package com.idofast.proxy.biz.adapter;


import com.idofast.common.dto.StateMessage;
import com.idofast.common.dto.StateReportDto;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.BaseResponseCode;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.exception.BusinessException;
import com.idofast.proxy.common.bean.ProxyConstant;
import com.idofast.proxy.common.util.UrlUtil;
import com.idofast.proxy.web.interceptor.AuthInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 运行时保持
 */
@Slf4j
@Component
public class ProxyAccountAdapt
{


    @Autowired
    RestTemplate restTemplate;


    @Autowired
    private UrlUtil urlUtil;

    @Value("${proxy.local.host}")
    private String serverHost;

    @Autowired
    private ProxyConstant proxyConstant;


    @PostConstruct
    public void verify()
    {
        if(StringUtils.isEmpty(serverHost))
        {
            throw new IllegalArgumentException("proxy.local.host变量未配置...");
        }
    }



    public V2rayAccountDto getRemoteV2rayAccountDto(Long id) throws BusinessException
    {
        log.info("开始请求 {}?id={}", urlUtil.getProxyInfoUrl(), id);
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("id", id);
        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>();
        headerMap.add(AuthInterceptor.AUTH_NAME, proxyConstant.getAuthPassword());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headerMap);
        ResponseEntity<ServerResponse<V2rayAccountDto>> entity = restTemplate.exchange(
                urlUtil.getProxyInfoUrl(),
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ServerResponse<V2rayAccountDto>>() {}
        );

        if (!entity.getStatusCode().is2xxSuccessful()) {
            throw new BusinessException("Http状态码错误:" +  entity.getStatusCode().getReasonPhrase());
        }
        ServerResponse<V2rayAccountDto> result = entity.getBody();
        if (result ==null || result.getStatus() != BaseResponseCode.SUCCESS.getCode()) {
            throw new BusinessException("远程获取账号结果发生错误: " + result.getMsg());
        }

        return result.getData();
    }

    /**
     *
     * @param list
     * @return  true上报成功， false上报失败，包括服务端返回异常，网络原因等
     */
    public boolean reportUserState(List<StateMessage> list)
    {


        MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>();
        headerMap.add(AuthInterceptor.AUTH_NAME, proxyConstant.getAuthPassword());

        StateReportDto dto = new StateReportDto();
        dto.setContents(list);
        dto.setHost(serverHost);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(dto,headerMap);
        ResponseEntity<ServerResponse> entity = restTemplate.exchange(
                urlUtil.getStateReportUrl(),
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<ServerResponse>() {}
        );

        if (!entity.getStatusCode().is2xxSuccessful()) {
            return false;
        }
        ServerResponse result = entity.getBody();
        if (result ==null || result.getStatus() != BaseResponseCode.SUCCESS.getCode()) {
            log.warn("远程提交用户状态数据发生错误:{}", result.getMsg());
            return false;
        }

        return true;
    }


}
