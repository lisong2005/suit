/**
 * Witontek.com.
 * Copyright (c) 2012-2016 All Rights Reserved.
 */
package ls.demon.commons.json;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * 
 * @author song.li@witontek.com
 * @version $Id: JsonUtil.java, v 0.1 2016年8月23日 上午8:33:25 song.li@witontek.com Exp $
 */
public class JsonUtils {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static String convertObjToJson(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JaxbAnnotationModule());
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 
     * @param jsonStr
     * @param clazz
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static <T> T convertJsonToObj(String jsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JaxbAnnotationModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(jsonStr, clazz);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
