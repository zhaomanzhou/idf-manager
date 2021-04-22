package com.idofast.admin.controller.vo.request;

import com.idofast.admin.domain.V2rayNode;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 1:45 上午
 */
@Data
public class V2rayNodeAddOrUpdateVo
{


    private Long id;
    /**
     * 节点名称
     */
    @NotNull
    private String name;

    /**
     * 访问域名
     */
    @NotNull
    private String host;


    /**
     * 访问端口
     */
    @NotNull
    private Integer port;

    /**
     * 是否开启了tls
     */
    private Boolean supportTls = true;

    /**
     * 协议  wmess/vless
     */
    @NotNull
    private String protocol;

    /**
     * 服务器是否上线
     */
    private Boolean enable = true;

    /**
     * 服务器等级
     */
    private  Integer level = 0;

    /**
     * 流量倍率， 单位1/10；  值为10，代表倍率1
     */
    private Integer magnification = 10;

    /**
     * 服务器速率，单位mbps
     */
    private Integer speed = 100;



    /**
     * 节点描述
     */
    private String description = "";



    /**
     * 节点信息， 只有管理员可见
     */
    private String messageForAdmin;


    /**
     * 节点管理host
     */
    private String apiHost;

    /**
     * 节点管理端口
     */
    private Integer apiPort;


    /**
     * 排序使用
     */
    private Long sequence;


    /**
     * 父节点ID
     */
    private Long parentNodeId = 0L;

    public static V2rayNode convertToV2rayNode(V2rayNodeAddOrUpdateVo vo)
    {
        V2rayNode node = new V2rayNode();
        BeanUtils.copyProperties(vo, node);
        return node;
    }


}
