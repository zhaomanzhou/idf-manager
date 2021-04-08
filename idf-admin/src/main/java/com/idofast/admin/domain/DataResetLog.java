package com.idofast.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/7 6:31 下午
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( indexes = {
        @Index(name = "idx_data_reset_user", columnList="userId", unique = false),
        @Index(name = "idx_data_reset_start_date", columnList="startDate", unique = false),
})
public class DataResetLog
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition="bigint")
    private Long id;

    @Column(updatable = false ,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '创建时间'",insertable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '更新时间'",insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;

    private Long userId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long usedData;
}
