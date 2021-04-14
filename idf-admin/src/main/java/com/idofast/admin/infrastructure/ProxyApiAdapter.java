package com.idofast.admin.infrastructure;

import com.idofast.admin.domain.User;
import com.idofast.admin.repository.UserRepository;
import com.idofast.admin.util.UrlUtil;
import com.idofast.common.dto.V2rayAccountDto;
import com.idofast.common.response.ResponseCode;
import com.idofast.common.response.ServerResponse;
import com.idofast.common.response.error.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
public class ProxyApiAdapter
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UrlUtil urlUtil;



    public void rmAccount(Long id , String host) throws BusinessException
    {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isPresent())
        {
            User user = byId.get();
            MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
            paramMap.add("id", id);
            paramMap.add("email", user.getEmail());

            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(paramMap);
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
        }
    }
}
