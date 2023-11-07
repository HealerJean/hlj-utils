package com.hlj.util.z028_灰度工具;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * GrayEnum
 * @author zhangyujin1
 * @date 2021/4/14  2:24 下午.
 */
public interface GrayEnum {


    /**
     * 灰度进度
     */
    @Getter
    @AllArgsConstructor
    enum GraySwitchEnum implements GrayEnum {

        /**
         * GRAY_CLOSE
         */
        GRAY_CLOSE("GrayClose", "灰度关闭"),
        GRAY_PERCENT("Percent", "灰度中"),
        ALL_PERCENT("AllPercent", "全量"),

        ;

        /**
         * code
         */
        private final String code;
        /**
         * desc
         */
        private final String desc;

        /**
         * GraySwitchEnum
         *
         * @param code code
         * @return GraySwitchEnum
         */
        public static GraySwitchEnum toGraySwitchEnum(String code) {
            return Arrays.stream(GraySwitchEnum.values()).filter(item -> item.getCode().equals(code)).findAny().orElse(null);
        }
    }



    /**
     * 灰度业务
     */
    @Getter
    @AllArgsConstructor
    enum GrayBusinessEnum implements GrayEnum {
        /**
         * INSURANCE_6067
         */
        BUSINESS_OOO1("businessDemo", "灰度场景1"),
        ;

        /**
         * insuranceId
         */
        private final String bizType;

        /**
         * desc
         */
        private final String bizDesc;


        /**
         * GrayBusinessEnum
         * @param bizType insuranceId
         * @return GrayBusinessEnum
         */
        public static GrayBusinessEnum toGrayBusinessEnum(String bizType) {
            return Arrays.stream(GrayBusinessEnum.values()).filter(item->item.getBizType().equals(bizType)).findAny().orElse(null);
        }
    }

}
