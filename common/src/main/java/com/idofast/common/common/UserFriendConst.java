package com.idofast.common.common;

public class UserFriendConst {

    public enum UserFriendStatus {
        BEVERIFIED_STATUS("待验证", 0),
        REFUSE_STATUS("拒绝", 1),
        AGREE_STATUS("同意", 2),
        TIMEOUT_STATUS("超时失效", 3),
        ;

        UserFriendStatus(String name, Integer code) {

            this.name = name;
            this.code = code;
        }

        private Integer code;
        private String name;

        public Integer getCode() {
            return this.code;
        }

        public String getName() {
            return this.name;
        }

        public static String getName(Integer code) {
            switch (code) {
                case 0:
                    return "待验证";
                case 1:
                    return "拒绝";
                case 2:
                    return "同意";
                case 3:
                    return "超时失效";
                default:
                    return "";
            }
        }
    }

    public enum UserFriendDeleted{
        NONDELETED(Byte.valueOf("0")),
        DELETED(Byte.valueOf("1"));

        UserFriendDeleted(Byte code)
        {
            this.code = code;
        }

        private Byte code;

        public Byte getCode()
        {
            return this.code;
        }
    }
}
