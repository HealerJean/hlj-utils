package com.hlj.util.z038_数工具.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuVo
 *
 * @author zhangyujin
 * @date 2024/8/2
 */
@Data
public class MenuVo {

    private Long id;

    private Long pId;

    private String name;

    private Integer rank = 0;

    private List<MenuVo> subMenus = new ArrayList<>();

    public MenuVo(Long id, Long pId) {
        this.id = id;
        this.pId = pId;
    }
}