package com.idofast.admin.domain.dto;

import com.idofast.admin.domain.Bundle;
import com.idofast.admin.domain.User;
import com.idofast.admin.domain.UserProxyInfo;
import com.idofast.admin.util.LocalDateTimeUtil;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.enums.UserStatusEnum;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/2/20 7:20 下午
 */
@Data
public class UserInfoLite
{

    public UserInfoLite(User u, UserProxyInfo userProxyInfo)
    {
        BeanUtils.copyProperties(u, this);
        BeanUtils.copyProperties(userProxyInfo, this);
        createTime = LocalDateTimeUtil.toTimeStamp(u.getCreateTime());
        nextSettleDate = LocalDateTimeUtil.toTimeStamp(userProxyInfo.getNextSettleDate());
        expireDate = LocalDateTimeUtil.toTimeStamp(userProxyInfo.getExpireDate());

        if(this.getBundleId() == null)
        {
            setBundleId(Bundle.DEFAULT_BUNDLE.getId());
            setBundleName(Bundle.DEFAULT_BUNDLE.getName());
        }

    }

    public UserInfoLite(Long id, LocalDateTime createTime, String email, String avatarUrl, RoleEnum role, UserStatusEnum status, String remark, Integer osDevice, String ext, Integer level, Long speed, Long totalData, Long usedData, LocalDateTime nextSettleDate, LocalDateTime expireDate, Integer maxConnection, Long bundleId, String bundleName, Integer totalActiveDay, Integer namespace)
    {
        this.id = id;
        this.createTime = LocalDateTimeUtil.toTimeStamp(createTime);
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.role = role;
        this.status = status;
        this.remark = remark;
        this.osDevice = osDevice;
        this.ext = ext;
        this.level = level;
        this.speed = speed;
        this.totalData = totalData;
        this.usedData = usedData;
        this.nextSettleDate = LocalDateTimeUtil.toTimeStamp(nextSettleDate);
        this.expireDate = LocalDateTimeUtil.toTimeStamp(expireDate);
        this.maxConnection = maxConnection;
        this.bundleId = bundleId;
        this.bundleName = bundleName;
        this.totalActiveDay = totalActiveDay;
        this.namespace = namespace;
    }

    private Long id;

    private Long createTime;


    private String email;

    private String avatarUrl;

    private RoleEnum role;

    //用户状态，0正常，1，封禁
    private UserStatusEnum status;

    //备注
    private String remark;

    //使用的设备
    private Integer osDevice;

    private String ext;



    private Integer level;


    /**
     * 限速,单位kb
     */
    private Long speed;

    /**
     *总流量,单位MB
     */
    private Long totalData;

    /**
     * 已用流量
     */
    private Long usedData;

    /**
     * 下一个结算日期
     */
    private Long nextSettleDate;

    /**
     * 过期时间
     */
    private Long expireDate;

    /**
     * 最大连接数
     */
    private Integer maxConnection;

    /**
     * 目前使用的套餐ID
     */
    private Long bundleId;

    /**
     * 目前使用的套餐名
     */
    private String bundleName;

    /**
     * vip总时间
     */
    private Integer totalActiveDay;

    /**
     * 账号命名空间
     */
    private Integer namespace;




}
