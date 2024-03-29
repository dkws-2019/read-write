package com.liuchao.readwrite.config;

import com.liuchao.readwrite.util.DBTypeEnum;

public class DBContextHolder {
    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();



    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
        System.out.println(contextHolder.get());
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        set(DBTypeEnum.SLAVE1);
        System.out.println("切换到SLAVE1");
    }

}
