package com.idofast.admin.controller.vo.response;

import cn.hutool.core.bean.BeanUtil;
import com.idofast.admin.domain.V2rayNode;
import lombok.Data;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/17 11:48 下午
 *
 * 服务器列表页面返回的数据
 */
@Data
public class ServerNodeResponse
{
    private Long id;
    private String name;
    private String host;
    private Integer port;
    private Boolean supportTls;
    private String protocol;
    private  Integer level;
    private Integer magnification;
    private Integer speed;
    private String description;
    private Integer connectionNum;
    //当前用户是否可用
    private boolean canUse;

    /**
     * 排序使用
     */
    private Long sequence;

    public static ServerNodeResponse convertFrom(V2rayNode node, Integer userLevel, Integer connectionNum)
    {
        ServerNodeResponse response = new ServerNodeResponse();
        BeanUtil.copyProperties(node, response);
        if(node.getLevel() > userLevel)
        {
            response.setHost("");
        }
        response.setConnectionNum(connectionNum);
        return response;
    }
}
