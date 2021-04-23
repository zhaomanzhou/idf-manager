package com.idofast.admin.infrastructure;

import com.idofast.admin.config.interceptor.ProxyApiAuthInterceptor;
import com.idofast.admin.domain.User;
import com.idofast.admin.repository.UserRepository;
import com.idofast.admin.util.UrlUtil;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.ResponseCode;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/14 7:31 下午
 */
@Component
@Slf4j
public class ProxyApiAdapter
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlUtil urlUtil;

    @Value("${proxy.authPassword}")
    private String authPassword;



    public void rmAccount(Long id , String host) throws BusinessException
    {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent())
        {
            User user = byId.get();
            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            paramMap.add("id", id);
            paramMap.add("email", user.getEmail());
            log.info("开始发起http删除用户调用，id:{}, email:{}", id, user.getEmail());


            MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>();
            headerMap.add(ProxyApiAuthInterceptor.AUTH_NAME, authPassword);

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap, headerMap);
            ResponseEntity<ServerResponse<V2rayAccountDto>> entity = restTemplate.exchange(
                    urlUtil.getRmAccountUrl(host),
                    HttpMethod.POST,
                    requestEntity,
                    new ParameterizedTypeReference<ServerResponse<V2rayAccountDto>>() {}
            );

            if (!entity.getStatusCode().is2xxSuccessful()) {
                throw new BusinessException("Http状态码错误:" +  entity.getStatusCode().getReasonPhrase());
            }
            ServerResponse<V2rayAccountDto> result = entity.getBody();
            if (result ==null || result.getStatus() != ResponseCode.SUCCESS.getCode()) {
                throw new BusinessException("远端回应错误: " + result.getMsg());
            }
            log.info("调用成功，{}已删除该用户{}", host, id);
            return;
        }
        log.warn("通知远端删除一个不存在id:{}", id);

    }
}
