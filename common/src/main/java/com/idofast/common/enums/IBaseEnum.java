package com.idofast.common.enums;

import java.util.Objects;

public interface IBaseEnum
{
    Integer getCode();

    String getValue();

    static <T extends IBaseEnum> T fromValue(Class<T> enumType, Integer value) {
        for (T object : enumType.getEnumConstants()) {
            if (Objects.equals(value, object.getValue())) {
                return object;
            }
        }
        throw new IllegalArgumentException("No enum value " + value + " of " + enumType.getCanonicalName());
    }
}
