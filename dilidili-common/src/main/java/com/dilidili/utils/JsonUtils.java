package com.dilidili.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * json解析工具类
 */
public class JsonUtils {
    public static String objectToJson(Object object) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            String json = gson.toJson(object);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
