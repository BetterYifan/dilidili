package com.dilidili.filter.admin.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class MultiLanguageConfigure {

    private static final HashMap<String, HashMap<Integer, String>> errCode = new HashMap<>();

    @Value("classpath:languages/*.json")
    private Resource[] resources;

    /**
     * @PostConstruct注解用于项目启动时执行这个方法
     */
    @PostConstruct
    private void init() {
        try {
            for (Resource resource : resources) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
                StringBuffer stringBuffer = new StringBuffer();
                String res = "";
                while ((res = reader.readLine()) != null) {
                    stringBuffer.append(res);
                }

                // 转为map对象
                HashMap map = JSONObject.parseObject(stringBuffer.toString(), HashMap.class);
                errCode.put(StringUtils.removeEnd(resource.getFilename(), ".json"), JSON.parseObject(map.get("errCode").toString(), HashMap.class));

            }
        } catch (Exception e) {
            System.out.println("error happen:" + e.getMessage());
        }

        System.out.println(errCode);
    }


}
