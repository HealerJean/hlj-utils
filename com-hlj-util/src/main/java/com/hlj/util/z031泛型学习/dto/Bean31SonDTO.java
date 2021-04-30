package com.hlj.util.z031泛型学习.dto;

import lombok.Data;

/**
 * @author zhangyujin
 * @date 2021/4/15  7:49 下午.
 * @description
 */
@Data
public class Bean31SonDTO<S extends Bean31ParentDTO>{

    private S son;

}
