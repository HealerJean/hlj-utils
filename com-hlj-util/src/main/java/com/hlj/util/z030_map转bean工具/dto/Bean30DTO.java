package com.hlj.util.z030_map转bean工具.dto;

import lombok.Data;

/**
 * @author zhangyujin
 * @date 2021/4/15  5:50 下午.
 * @description
 */
@Data
public class Bean30DTO extends Bean30ParentDTO {

    private String name;

    private Bean30InnerDTO bean30InnerDTO;


}
