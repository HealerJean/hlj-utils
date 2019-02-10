package com.hlj.util.zz001Domain.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Desc: 微信消息格式以及xml和对象的转化
 * @Date:  2018/5/24 下午5:54.


    <!--对象转xml-->
    <dependency>
        <groupId>com.thoughtworks.xstream</groupId>
        <artifactId>xstream</artifactId>
        <version>1.4.9</version>
    </dependency>

    <!--将request流转化为map-->
    <dependency>
        <groupId>dom4j</groupId>
        <artifactId>dom4j</artifactId>
        <version>1.6.1</version>
    </dependency>

 */

public class XmlUtil {


    /**
     * XML格式字符串转map
     */
    public static Map<String, String> xmlToMap(String xmlStr) {
        Map<String, String> map = null;
        try {
            map = new HashMap<String, String>();
            Document document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            for (Element e : elementList)
                map.put(e.getName(), e.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return map;
    }




    /**
     * Map转换为xml
     * @param map
     * @return
     */
    public static String map2XmlString(Map<String, String> map) {
        String xmlResult = "";

        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        for (String key : map.keySet()) {
            System.out.println(key + "========" + map.get(key));

            String value = "<![CDATA[" + map.get(key) + "]]>";
            sb.append("<" + key + ">" + value + "</" + key + ">");
            System.out.println();
        }
        sb.append("</xml>");
        xmlResult = sb.toString();

        return xmlResult;
    }







}