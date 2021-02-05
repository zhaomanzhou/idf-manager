package com.idofast.admin.service;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/4 4:25 下午
 */

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.idofast.admin.config.properties.AlipayProperties;
import com.idofast.common.response.error.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
@Slf4j
public class AliPayService implements InitializingBean
{

    @Autowired
    private AlipayProperties alipayProperties;


    /**
     * 调用支付宝支付，返回支付链接
     */
    public AlipayTradePrecreateResponse toPay(String subject, String orderId, Long money) throws BusinessException
    {

        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace().preCreate(subject, orderId, (money*0.01) + "");
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                log.info("订单{}调用支付宝生成支付宝订单调成功", orderId);

                return response;
            } else {
                log.warn("订单{}调用支付宝支付失败，失败原因{}", orderId, response.msg + "，" + response.subMsg);
                throw new BusinessException("调用支付宝失败");
            }
        } catch (Exception e) {
            log.warn("订单{}调用支付宝遭遇异常，原因：{}",orderId, e.getMessage());
            throw new BusinessException("调用支付宝失败");
        }
    }

    public boolean rsaCheck(Map<String, String[]> requestParams){
        try {
            Map<String, String> params = new HashMap<>();
            for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
                String name = (String) iter.next();
                String[] values = requestParams.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                }
                params.put(name, valueStr);
            }

            Boolean legal = Factory.Payment.Common()
                    .verifyNotify(params);
            return legal;
        } catch (Exception e) {
            log.debug("verify sigin error, exception is:{}", e.toString());
            return false;
        }
    }



    @Override
    public void afterPropertiesSet()
    {
        Config config = new Config();

        config.protocol = alipayProperties.getProtocol();
        config.gatewayHost = alipayProperties.getGatewayHost();
        config.signType = alipayProperties.getSignType();

        config.appId = alipayProperties.getAppId();

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = alipayProperties.getMerchantPrivateKey();

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
        config.alipayPublicKey = alipayProperties.getAlipayPublicKey();
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = alipayProperties.getNotifyUrl();

        Factory.setOptions(config);
    }
}
