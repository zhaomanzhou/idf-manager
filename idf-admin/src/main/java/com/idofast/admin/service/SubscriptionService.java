package com.idofast.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.domain.V2rayNode;
import com.idofast.admin.repository.UserProxyInfoRepository;
import com.idofast.admin.repository.V2rayNodeRepository;
import com.idofast.common.response.error.BusinessException;
import com.idofast.common.util.JsonUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 9:38 下午
 */
@Service
public class SubscriptionService
{
    
    @Autowired
    private UserProxyInfoRepository userProxyInfoRepository;

    @Autowired
    private V2rayNodeRepository v2rayNodeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取订阅内容，base64处理过的
     * @param subscribeCode
     * @return
     */
    public String getSubscriptionContent(String subscribeCode) throws BusinessException
    {
        Optional<UserProxyInfo> proxyInfoOptional = userProxyInfoRepository.findBySubscribeCodeEquals(subscribeCode);
        if(proxyInfoOptional.isEmpty())
        {
            throw new BusinessException("错误的订阅码");
        }

        UserProxyInfo proxyInfo = proxyInfoOptional.get();

        List<V2rayNode> allNodes = v2rayNodeRepository.findAllByLevelIsLessThanEqual(proxyInfo.getLevel());


        return buildBase64Subscription(allNodes, proxyInfo);
    }


    public String buildBase64Subscription(List<V2rayNode> allNodes, UserProxyInfo proxyInfo)
    {
        StringBuilder sb = new StringBuilder();

        for (V2rayNode node : allNodes)
        {

            V2rayNsEntity entity = new V2rayNsEntity();
            entity.setId(proxyInfo.getUuid());
            entity.setAdd(node.getHost());
            entity.setPort(node.getPort() + "");
            entity.setTls(node.getSupportTls()? "tls": "");
            entity.setHost("");
            entity.setPs(node.getName());
            entity.setPath("/ws/" + proxyInfo.getId());


            String encode = Base64.getEncoder().encodeToString(JsonUtil.obj2StringPretty(entity).getBytes(StandardCharsets.UTF_8));
            sb.append("vmess://").append(encode).append("\n");
        }

        return sb.toString();
    }


    @Data
    static class V2rayNsEntity{
        String v = "2";
        String ps = "";
        String add;
        String port;
        String id;
        String aid = "1";
        String net = "ws";
        String type = "none";
        String host ="";
        String path;
        String tls = "tls";
    }
}
