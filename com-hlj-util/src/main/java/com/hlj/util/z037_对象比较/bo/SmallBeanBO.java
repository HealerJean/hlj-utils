package com.hlj.util.z037_对象比较.bo;

import com.hlj.util.z037_对象比较.Compare;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * SmallBeanBO
 *
 * @author zhangyujin
 * @date 2023/12/20
 */
@Accessors(chain = true)
@Data
public class SmallBeanBO implements Serializable {

    /**
     * smallAge
     */
    @Compare("smallName")
    private String smallName;

    /**
     * smallAge
     */
    @Compare("smallAge")
    private Integer smallAge;
}
