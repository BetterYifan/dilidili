package io;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileToJson {
    private static final Logger logger = LoggerFactory.getLogger(FileToJson.class);

    /**
     * 读取文件内容
     *
     * @param fullPath
     * @return
     */
    public static Map readFile(String fullPath) {
        StringBuilder stringBuilder = new StringBuilder();
        Map map = new LinkedHashMap();
        try {
            ClassPathResource classPathResource = new ClassPathResource(fullPath);
            String content = IOUtils.toString(new InputStreamReader(classPathResource.getInputStream(), "UTF-8"));
            // 转为map对象
            map = JSONObject.parseObject(content, LinkedHashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
