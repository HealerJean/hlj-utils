package com.hlj.util.Z018_继承.dto;

import lombok.Data;

/**
 * @author HealerJean
 * @ClassName Son
 * @date 2019/11/12  15:31.
 * @Description
 */
@Data
public class Son extends Father{

    // public String name = "儿子";

    @Override
    public String printName() {
        return this.name;
    }
    @Override
    public String printGetName() {
        return this.getName();
    }
}
