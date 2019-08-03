package com.hlj.util.Z014Json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.Writer;

/**
 * Utils - JSON
 */
public final class JsonUtils {

    /**
     * ObjectMapper
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper  objectMapperSensitivity = new ObjectMapper();


    static {


        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //NULL 不打印
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 排除json字符串中实体类没有的字段
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

    }



    /**
     * 将对象转换为JSON字符串
     *
     * @param value 对象
     * @return JSON字符串
     */
    public static String toJsonString(Object value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json      JSON字符串
     * @param c 类型
     * @return 对象
     */
    public static <T> T toObject(String json, Class<T> c) {
        try {
            return OBJECT_MAPPER.readValue(json, c);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    /**
     * 将JSON字符串转换为树
     * @param json JSON字符串
     * @return 树
     */
    public static JsonNode toJsonNode(String json) {
        try {
            return OBJECT_MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("参数格式有误");
        }
    }

    /**
     * json格式字符串转对象
     * @param json
     * @param c
     * @return object 仅限于 ArrayList HashSet 等集合对象
     */
    public static<T>  T toCollect(String json, Class c ,Class collect){
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(collect, c);
        try {
            return OBJECT_MAPPER.readValue(json, javaType);
        } catch (IOException e){
            throw new RuntimeException("参数格式有误");
        }
    }













}
