package com.idofast.admin.controller.vo.response;

import com.idofast.admin.domain.RechargeLog;
import com.idofast.common.util.LocalDateTimeUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 4:16 下午
 */

@Data
public class RechargeLogVo
{

    private Long id;


    private Long createTime;


    private Long updateTime;


    /**
     * 充值的对象
     */
    private Long userId;

    /**
     * 对应的订单Id
     */
    private Long orderId;

    /**
     * 是否手工充值
     */
    private Boolean humanRecharge;

    /**
     * 充值的套餐Id
     */
    private Long bundleId;

    /**
     * 充值的套餐名
     */
    private String bundleName;

    /**
     * 套餐周期天数
     */
    private Integer duration;

    /**
     * 充值了几个
     */
    private Integer rechargeNum;

    /**
     * 充值前到期时间
     */
    private Long prevExpireDate;

    /**
     * 充值前的套餐Id
     */
    private Long prevBundleId;


    /**
     * 充值前的套餐名
     */
    private String prevBundleName;

    public static RechargeLogVo convertToVo(RechargeLog log)
    {
        RechargeLogVo vo = new RechargeLogVo();
        BeanUtils.copyProperties(log, vo);
        vo.setCreateTime(LocalDateTimeUtil.toTimeStamp(log.getCreateTime()));
        vo.setUpdateTime(LocalDateTimeUtil.toTimeStamp(log.getUpdateTime()));
        vo.setPrevExpireDate(LocalDateTimeUtil.toTimeStamp(log.getPrevExpireDate()));
        return vo;
    }


}
