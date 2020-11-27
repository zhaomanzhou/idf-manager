package com.idofast.admin.domain;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailEventHistory extends BaseEntity implements Serializable {

    private String email;

    private String event;

    /**
     * 下次可以发送的时间
     */
    private Date  unlockDate;





}

