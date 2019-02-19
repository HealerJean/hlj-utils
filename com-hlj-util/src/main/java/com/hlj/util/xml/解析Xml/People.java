package com.hlj.util.xml.解析Xml;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 作者 ：HealerJean
 * 日期 ：2019/2/18  下午3:05.
 * 类描述：
 */
@Data
@Accessors(chain = true)
public class People {
    private String id;
    private String name;
    private String englishName;
    private String age;

}