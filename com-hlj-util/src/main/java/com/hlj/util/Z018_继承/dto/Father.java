package com.hlj.util.Z018_继承.dto;

import lombok.Data;

/**
 * @author HealerJean
 * @ClassName Father
 * @date 2019/11/12  15:31.
 * @Description
 */
@Data
public class Father {

    public String name = "父亲";

    public String printName() {
        return this.name;
    }

    public String printGetName() {
        return this.getName();
    }
}
