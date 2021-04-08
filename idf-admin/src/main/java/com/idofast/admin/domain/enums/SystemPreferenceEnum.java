package com.idofast.admin.domain.enums;

/**
 * @author zhaomanzhou
 * @version 1.0
 * @createTime 2021/4/4 11:46 下午
 */
public enum SystemPreferenceEnum
{
    //空闲使用时间,单位 分钟， 类型  int
    FREE_USER_TIME("FREE_USER_TIME", 60*24 + "" ),
    // 流量重置天数， 单位 天， 类型 int
    DATA_RESET_PERIOD("DATA_RESET_PERIOD", 30 + ""),

    INSTRUCTION_LINK_ANDROID("INSTRUCTION_LINK_ANDROID", ""),
    INSTRUCTION_LINK_IOS("INSTRUCTION_LINK_IOS", ""),
    INSTRUCTION_LINK_MAC("INSTRUCTION_LINK_MAC", ""),
    INSTRUCTION_LINK_WINDOWS("INSTRUCTION_LINK_WINDOWS", ""),
    INSTRUCTION_LINK_LINUX("INSTRUCTION_LINK_LINUX", ""),
    INSTRUCTION_LINK_UPDATE_SUBSCRIPTION("INSTRUCTION_LINK_UPDATE_SUBSCRIPTION", ""),
    DASHBOARD_NOTICE_LINK("DASHBOARD_NOTICE_LINK", "");

    SystemPreferenceEnum(String key, String defaultValue)
    {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    private String key;

    private String defaultValue;


    public String getKey()
    {
        return key;
    }

    public String getDefaultValue()
    {
        return defaultValue;
    }

   public static SystemPreferenceEnum ofKey(String key)
   {
       SystemPreferenceEnum[] values = SystemPreferenceEnum.values();
       for(SystemPreferenceEnum preferenceEnum: values)
       {
           if(preferenceEnum.getKey().equals(key))
           {
               return preferenceEnum;
           }
       }

       return null;
   }
}
