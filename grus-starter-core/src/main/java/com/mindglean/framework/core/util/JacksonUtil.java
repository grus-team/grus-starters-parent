package com.mindglean.framework.core.util;


import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * Jackson工具类
 *
 * @author aircjm
 */
@Slf4j
public class JacksonUtil {
    static ObjectMapper mapper = new ObjectMapper();

    public JacksonUtil() {
    }

    public static String toStr(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("Object to Json Str error", e);
        }
        return null;
    }


    public static <T> T toBean(String jsonStr, Class<T> valueType) {
        if (StrUtil.isBlank(jsonStr)) {
            return null;
        }
        try {
            return mapper.readValue(jsonStr, valueType);
        } catch (JsonProcessingException e) {
            log.error("jsonStr to Object error", e);
        }
        return null;
    }

    static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}