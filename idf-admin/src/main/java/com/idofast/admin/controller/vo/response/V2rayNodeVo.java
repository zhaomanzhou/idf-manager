package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.V2rayNode;
import com.idofast.common.util.LocalDateTimeUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 11:32 上午
 */
@Data
public class V2rayNodeVo
{
    private Long id;


    private Long createTime;


    private Long updateTime;


    /**
     * 节点名称
     */
    private String name;

    /**
     * 访问域名
     */
    private String host;

    /**
     * 服务器的ip
     */
    private String ip;

    /**
     * 访问端口
     */
    private Integer port;

    /**
     * 是否开启了tls
     */
    private Boolean supportTls;

    /**
     * 协议  wmess/vless
     */
    private String protocol;

    /**
     * 服务器是否上线
     */
    private Boolean enable;

    /**
     * 服务器等级
     */
    private  Integer level;

    /**
     * 流量倍率， 单位1/10；  值为10，代表倍率1
     */
    private Integer magnification;

    /**
     * 服务器速率，单位mbps
     */
    private Integer speed;



    /**
     * 节点描述
     */
    private String description;

    /**
     * 节点信息， 只有管理员可见
     */
    private String messageForAdmin;



    /**
     * transitNode为true是有效， 父节点id
     */
    private Long parentNodeId;


    /**
     * 父节点名称
     */

    private String parentName;

    /**
     * 父节点域名
     */
    private String parentHost;



    public static V2rayNodeVo convertFrom(V2rayNode node)
    {
        V2rayNodeVo vo = new V2rayNodeVo();
        BeanUtils.copyProperties(node, vo);
        vo.setCreateTime(LocalDateTimeUtil.toTimeStamp(node.getCreateTime()));
        vo.setUpdateTime(LocalDateTimeUtil.toTimeStamp(node.getUpdateTime()));
        return vo;
    }
}
