package com.hlj.util.z030_map转bean工具;
import com.hlj.util.z030_map转bean工具.dto.Bean30DTO;
import com.hlj.util.z030_map转bean工具.dto.Bean30InnerDTO;
import com.hlj.util.z030_map转bean工具.utils.BeanMapUtils;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * @author zhangyujin
 * @date 2021/4/15  5:51 下午.
 * @description
 */
@Slf4j
public class TestMain {

    public String toJson(Object object){
        return JSONObject.fromObject(object).toString();
    }

    @Test
    public void test(){
        Bean30DTO bean30DTO = new Bean30DTO();
        // bean30DTO.setName("name");
        bean30DTO.setBean30InnerDTO(new Bean30InnerDTO().setInner("inner"));
        bean30DTO.setParent("parent");

        //1、bean转化为map
        Map<String, Object> map = BeanMapUtils.beanToMap(bean30DTO);
        System.out.println(toJson(map));

        //2、map转bean
        Bean30DTO newBean30DTO = BeanMapUtils.mapToBean(map, Bean30DTO.class);
        System.out.println(toJson(newBean30DTO));
    }



}
