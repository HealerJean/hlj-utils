package com.hlj.util.z031泛型学习.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhangyujin
 * @date 2021/4/15  7:34 下午.
 * @description
 */
@Data
@Accessors(chain = true)
public class Bean03DTO<A, N> {

    private A age;
    private N name;
}
