package com.idofast.admin.domain;

import com.idofast.admin.util.RoleEnumConvert;
import com.idofast.common.enums.RoleEnum;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


    //用户状态，1正常，0，封禁
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Integer status;

    //备注
    private String remark;

    //使用的设备
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer osDevice;

    private String ext;

    @Transient
    private String vCode;

}
