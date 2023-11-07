package com.hlj.util.z028_灰度工具;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;


/**
 * 自制工具类
 *
 * @author healerjean
 * @date 2022-09-21 22:27
 */
@Service
@Slf4j
public class GrayUtil {

    /**
     * grayConfiguration
     */
    @Resource
    private GrayConfiguration grayConfiguration;

    /**
     * 是否命中灰度
     *
     * @param grayBusinessEnum 灰度业务枚举
     * @param grayObject       灰度值
     * @return 灰度开关是否打开
     */
    public <T> boolean hitGray(GrayEnum.GrayBusinessEnum grayBusinessEnum, T grayObject) {
        if (Objects.requireNonNull(grayBusinessEnum) == GrayEnum.GrayBusinessEnum.BUSINESS_OOO1) {
            return grayBusinessDemo((String) grayObject);
        }
        return false;
    }


    /**
     * ducc险种灰度开关 (定制化)
     * 1、如果配置中间配置为空则返回 灰度关闭
     * 2、灰度开关判断
     * 2.1、如果灰度开关状态不存在或者开关关闭，则返回false
     * 2.2、如果灰度开关状态显示全量，则返回true
     * 3、商家白名单判断,如果商家在白名单，则返回true
     * 4、灰度比例判断
     * 4.1、灰度比例不存在，则返回false
     * 4.2、灰度比例计算，命中返回ture，不命中返回false
     *
     * @return 路由切换开关
     */
    private boolean grayBusinessDemo(String userId) {
        GrayBusinessDemoBO grayBusiness = grayConfiguration.getGrayBusiness();
        // 1、如果配置中间配置为空则返回 灰度关闭
        if (Objects.isNull(grayBusiness)) {
            return false;
        }

        // 2、灰度开关判断
        // 2.1、如果灰度开关状态不存在或者开关关闭，则返回false
        String graySwitchCode = grayBusiness.getGraySwitchCode();
        GrayEnum.GraySwitchEnum graySwitchEnum = GrayEnum.GraySwitchEnum.toGraySwitchEnum(graySwitchCode);
        if (Objects.isNull(graySwitchEnum) || GrayEnum.GraySwitchEnum.GRAY_CLOSE == graySwitchEnum) {
            return false;
        }

        // 2.2、如果灰度开关状态显示全量，则返回true
        if (GrayEnum.GraySwitchEnum.ALL_PERCENT == graySwitchEnum) {
            return true;
        }
        if (GrayEnum.GraySwitchEnum.GRAY_PERCENT != graySwitchEnum) {
            return false;
        }

        // 3、商家白名单判断,如果商家在白名单，则返回true
        Set<String> whiteUsers = grayBusiness.getWhiteUsers();
        if (!CollectionUtils.isEmpty(whiteUsers) && whiteUsers.contains(userId)) {
            log.info("[GrayUtil#grayBusinessDemo] 白名单用户命中，userId:{}, whiteUsers:{}：灰度状态：true", userId, whiteUsers);
            return true;
        }

        // 4.1、灰度比例不存在，则返回false
        Integer grayPercent = grayBusiness.getGrayPercent();
        Integer grayPercentAmount = grayBusiness.getGrayPercentAmount();
        if (Objects.isNull(grayPercent) || Objects.isNull(grayPercentAmount)) {
            return false;
        }
        // 4.2、灰度比例计算，命中返回ture，不命中返回false
        int hashCode = userId.hashCode();
        int rate = Math.abs(hashCode) % grayPercentAmount;
        if (rate <= grayPercent) {
            log.info("[GrayUtil#grayBusinessDemo] userId:{}，命中灰度:{} grayPercent:{}, grayPercentAmount:{}， 灰度状态：true", userId, rate, grayPercent, grayPercentAmount);
            return true;
        }
        return false;
    }

}
