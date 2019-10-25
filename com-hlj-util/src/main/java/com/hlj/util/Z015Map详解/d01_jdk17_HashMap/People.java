package com.hlj.util.Z015Map详解.d01_jdk17_HashMap;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author HealerJean
 * @ClassName People
 * @date 2019/10/14  16:22.
 * @Description
 */
@Data
public class People  implements Comparable<People>{
    private String username;
    private String password;
    private Integer id;
    private String name;

    @Override
    public int compareTo(People p) {
        return id - p.getId();
    }
}
