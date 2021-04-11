package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.V2rayNode;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/11 10:53 上午
 */
@Data
public class DirectV2rayNodeVo
{
    private Long id;
    private String name;
    private String host;

    public static DirectV2rayNodeVo convertFrom(V2rayNode v2rayNode)
    {
        DirectV2rayNodeVo vo = new DirectV2rayNodeVo();
        BeanUtils.copyProperties(v2rayNode, vo);
        return vo;
    }
}
