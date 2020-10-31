package com.idofast.common.common;

public class RoomConst {
    public enum RoomStatus{
        NONDELETED(Byte.valueOf("0")),
        DELETED(Byte.valueOf("1"));

        RoomStatus(Byte code)
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
