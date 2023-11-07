package com.hlj.util.z028_灰度工具;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * GrayInsuranceBusinessDto
 * @author zhangyujin
 * @date 2022/9/22  13:48.
 */
@Data
public class GrayBusinessDemoBO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5110796299306482078L;
    /**
     * 灰度开关（GraySwitchEnum）
     */
    private String graySwitchCode;

    /**
     * 灰度比例
     */
    private Integer grayPercent;

    /**
     * 灰度总额
     */
    private Integer grayPercentAmount;

    /**
     * 灰度白名单用户
     */
    private Set<String> whiteUsers;

}
