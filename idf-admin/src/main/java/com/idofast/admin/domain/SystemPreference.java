package com.idofast.admin.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2020/12/31 4:57 下午
 */

@Entity
@Data
public class SystemPreference
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(columnDefinition="bigint")
    private Long id;

    private String PreKey;

    /**
     * value 是mysql关键字
     */
    private String PreValue;
}
