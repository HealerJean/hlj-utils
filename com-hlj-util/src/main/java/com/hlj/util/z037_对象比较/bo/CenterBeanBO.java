package com.hlj.util.z037_对象比较.bo;

import com.hlj.util.z037_对象比较.Compare;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * CenterBeanBO
 *
 * @author zhangyujin
 * @date 2023/12/20
 */
@Accessors(chain = true)
@Data
public class CenterBeanBO implements Serializable {

    /**
     * centerName
     */
    @Compare("centerName")
    private String centerName;

    /**
     * centerAge
     */
    @Compare("centerAge")
    private Integer centerAge;

    /**
     * smallBean
     */
    @Compare("smallBean")
    private SmallBeanBO smallBean;
}

