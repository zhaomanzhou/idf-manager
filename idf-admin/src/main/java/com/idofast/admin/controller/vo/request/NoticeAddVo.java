package com.idofast.admin.controller.vo.request;


import com.idofast.admin.domain.Notice;
import com.idofast.admin.util.OrderByTimeUtil;
import com.idofast.common.enums.NoticeStatusEnum;
import com.idofast.common.enums.NoticeVisibilityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.codehaus.jackson.map.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("文章公告的vo对象")
public class NoticeAddVo
{
    @NotNull(message = "标题不能为空")
    @ApiModelProperty("公告标题")
    private String title;

    @NotNull(message = "公告内容不能为空")
    @ApiModelProperty("公告内容markdown格式")
    private String contentMarkdown;

    @NotNull(message = "公告内容不能为空")
    @ApiModelProperty("公告内容html格式")
    private String contentHtml;

    @ApiModelProperty("是否发布公告； 0 - 保存为草稿；1 - 发布")
    @Min(value = 0, message = "只能为0或1")
    @Max(value = 1,message = "只能为0或1")
    private Integer status;

    @ApiModelProperty("公告可见性范围；0 - 所有人可见；1 - 只有注册用户可见；2 - 只有管理员可见")
    @Min(value = 0, message = "只能为0，1，2之间的数值")
    @Max(value = 2,message = "只能为0，1，2之间的数值")
    private Integer visibility;

    public static Notice convertToNotice(NoticeAddVo noticeAddVo)
    {
        Notice notice = new Notice();
        BeanUtils.copyProperties(noticeAddVo, notice);
        notice.setStatus(NoticeStatusEnum.codeOf(noticeAddVo.getStatus()));
        notice.setVisibility(NoticeVisibilityEnum.codeOf(noticeAddVo.getVisibility()));
        notice.setOrderValue(OrderByTimeUtil.getOrderByCurTime());
        notice.setStick(false);
        return notice;
    }

}
