package com.idofast.admin.domain;

import com.idofast.admin.domain.enumconvert.RoleEnumConvert;
import com.idofast.admin.domain.enumconvert.UserStatusConvert;
import com.idofast.common.enums.RoleEnum;
import com.idofast.common.enums.UserStatusEnum;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User extends BaseEntity implements Serializable
{

    private String nickname;

    @Column(columnDefinition = "",unique = true, nullable = false)
    private String email;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Convert(converter = RoleEnumConvert.class)
    private RoleEnum role;


    //用户状态，0正常，1，封禁
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    @Convert(converter = UserStatusConvert.class)
    private UserStatusEnum status;

    //备注
    private String remark;

    //使用的设备
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer osDevice;

    private String ext;


    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '更新时间'",insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateTime;

    @Transient
    private String vCode;

}
