package com.hlj.util.z028_灰度工具;

import org.junit.Test;

import static com.hlj.util.z028_灰度工具.GrayUtil.hitGray;

/**
 * @author zhangyujin
 * @date 2021/4/15  5:52 下午.
 * @description
 */
public class TestMain {


    @Test
    public void testTopicChange() {
        //1、命中灰度白名单
        System.out.println(hitGray(GrayEnum.GrayBusinessEnum.TOPIC_CHANGE, 10, 0, GrayEnum.GrayPercentEnum.ONE_HUNDRED));

        //2、灰度百分比未命中
        System.out.println(hitGray(GrayEnum.GrayBusinessEnum.TOPIC_CHANGE, 12, 1, GrayEnum.GrayPercentEnum.ONE_HUNDRED));

        //3、灰度百分比命中
        System.out.println(hitGray(GrayEnum.GrayBusinessEnum.TOPIC_CHANGE, 12, 12, GrayEnum.GrayPercentEnum.ONE_HUNDRED));

    }


    @Test
    public void testHelmetOnline() {
        //1、命中灰度白名单
        System.out.println(hitGray(GrayEnum.GrayBusinessEnum.HELMET_ONLINE, "81", 10, GrayEnum.GrayPercentEnum.ONE_HUNDRED));

        //2、灰度百分比未命中
        System.out.println(hitGray(GrayEnum.GrayBusinessEnum.HELMET_ONLINE, "11", 67, GrayEnum.GrayPercentEnum.ONE_HUNDRED));

        //3、灰度百分比命中
        System.out.println(hitGray(GrayEnum.GrayBusinessEnum.HELMET_ONLINE, "11", 68, GrayEnum.GrayPercentEnum.ONE_HUNDRED));
    }

}
