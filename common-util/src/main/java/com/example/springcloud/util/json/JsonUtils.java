package com.example.springcloud.util.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  Json字符串转换工具类
 * @author wangyushuai@fang.com
 * @date 2018/10/26
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    
    //对象转字符串
    public static <T> String obj2String(T obj){
        if (obj == null){
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //字符串转对象
    public static <T> T string2Obj(String str,Class<T> clazz){
        if (StringUtils.isEmpty(str) || clazz == null){
            return null;
        }
        try {
            return clazz.equals(String.class)? (T) str :objectMapper.readValue(str,clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * json字符串转JsonNode对象的方法
     */
    public static JsonNode str2JsonNode(String str){
        try {
            return  objectMapper.readTree(str);
        } catch (IOException e) {
            return null;
        }
    }

}
