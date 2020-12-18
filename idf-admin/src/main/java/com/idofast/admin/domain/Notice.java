package com.idofast.admin.domain;

import com.idofast.common.enums.NoticeStatusEnum;
import com.idofast.common.enums.NoticeVisibilityEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notice extends BaseEntity
{
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告内容；markdown格式
     */
    @Column(columnDefinition="TEXT")
    private String contentMarkdown;
    /**
     * 公告内容；html格式
     */
    @Column(columnDefinition="TEXT")
    private String contentHtml;
    /**
     * 公告状态：上线；下线；草稿
     */
    private NoticeStatusEnum status;
    /**
     * 公告可见范围；全部；注册用户
     */
    private NoticeVisibilityEnum visibility;
    /**
     * 公告是否置顶
     */
    private Boolean stick;
    /**
     * 公告序列值，默认为发布时间，排序用
     * order： mysql关键字
     */
    private Long orderValue;

    /**
     * 发布人id
     */
    private Long publisherId;
}
