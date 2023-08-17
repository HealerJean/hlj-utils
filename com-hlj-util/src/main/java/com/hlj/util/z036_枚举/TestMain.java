package com.hlj.util.z036_枚举;

import org.junit.Test;

/**
 * TestMain
 *
 * @author zhangyujin
 * @date 2023/6/12  09:35.
 */
public class TestMain {

    @Test
    public void test() {
        System.out.println(EnumCache.findByName(StatusEnum.class, "SUCCESS"));
        // 返回默认值StatusEnum.SUCCESS
        System.out.println(EnumCache.findByName(StatusEnum.class, "SUCCESS", null));
        // 返回默认值StatusEnum.SUCCESS
        System.out.println(EnumCache.findByName(StatusEnum.class, null, StatusEnum.INIT));
        // 返回默认值StatusEnum.INIT
        System.out.println(EnumCache.findByName(StatusEnum.class, "ERROR", StatusEnum.INIT));
        // 返回默认值StatusEnum.INIT


        System.out.println(EnumCache.findByValue(StatusEnum.class, "S"));
        // 返回默认值StatusEnum.SUCCESS
        System.out.println(EnumCache.findByValue(StatusEnum.class, "S", null));
        // 返回默认值StatusEnum.SUCCESS
        System.out.println(EnumCache.findByValue(StatusEnum.class, null, StatusEnum.INIT));
        // 返回默认值StatusEnum.INIT
        System.out.println(EnumCache.findByValue(StatusEnum.class, "ERROR", StatusEnum.INIT));
        // 返回默认值StatusEnum.INIT
    }
}
