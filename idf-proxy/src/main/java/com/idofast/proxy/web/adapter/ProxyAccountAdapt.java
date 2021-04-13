package com.idofast.proxy.web.adapter;


import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.ResponseCode;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import com.idofast.proxy.service.V2rayService;
import com.idofast.proxy.util.UrlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

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
    private V2rayService v2rayService;

    @Autowired
    private UrlUtil urlUtil;



    public V2rayAccountDto getRemoteV2rayAccountDto(Long id) throws BusinessException
    {
        log.info("开始请求 {}?id={}", urlUtil.getProxyInfoUrl(), id);
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("id", "12233");

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap);
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
        if (result ==null || result.getStatus() != ResponseCode.SUCCESS.getCode()) {
            log.warn("远程获取账号结果发生错误:{}", result.getMsg());
            return null;
        }

        return result.getData();
    }

}
