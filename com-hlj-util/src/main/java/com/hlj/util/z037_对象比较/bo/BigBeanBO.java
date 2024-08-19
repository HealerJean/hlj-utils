package com.hlj.util.z037_对象比较.bo;

import com.hlj.util.z037_对象比较.Compare;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * BigBeanBO
 *
 * @author zhangyujin
 * @date 2023/12/20
 */
@Accessors(chain = true)
@Data
public class BigBeanBO implements Serializable {

    /**
     * bigName
     */
    @Compare("bigName")
    private String bigName;

    /**
     * bigAge
     */
    @Compare("bigAge")
    private Integer bigAge;

    /**
     * centerBean
     */
    @Compare("centerBean")
    private CenterBeanBO centerBean;
}
