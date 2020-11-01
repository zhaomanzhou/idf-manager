package com.idofast.admin.domain;


import com.idofast.common.enums.EmailTypeEnum;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailSendHistory extends BaseEntity
{

    private String content;
    private String receiver;
    @Enumerated(EnumType.STRING)
    private EmailTypeEnum emailTypeEnum;
}
