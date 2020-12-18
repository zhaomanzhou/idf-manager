package com.idofast.admin.annotation;


import com.idofast.common.enums.RoleEnum;
import springfox.documentation.annotations.ApiIgnore;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER}) // 可用在方法的参数上
@Retention(RetentionPolicy.RUNTIME)
@ApiIgnore
public @interface CurUser
{

}
