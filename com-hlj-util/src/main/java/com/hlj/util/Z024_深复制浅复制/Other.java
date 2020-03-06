package com.hlj.util.Z024_深复制浅复制;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author HealerJean
 * @ClassName Other
 * @date 2020/3/6  18:08.
 * @Description
 */
@Data
@Accessors(chain = true)
public class Other {
    private String name ;
    private Me me ;

    @Data
   public static class Me{
        private int age;
    }
}
