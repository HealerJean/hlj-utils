package com.hlj.util.z037_对象比较;

import lombok.Data;

/**
 * CompareNode
 *
 * @author zhangyujin
 * @date 2023/12/20
 */
@Data
public class CompareNode {

    /**
     * 是否变更
     */
    private boolean changeFlag;

    /**
     * 字段
     */
    private String fieldKey;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 路径
     */
    private String fieldPath;

    /**
     * 状态
     */
    private String fieldState;

    /**
     * 字段老值
     */
    private Object oldValue;

    /**
     * 字段新值
     */
    private Object newValue;




}
