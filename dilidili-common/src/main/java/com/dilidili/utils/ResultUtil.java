package com.dilidili.utils;

import cn.hutool.json.JSONUtil;
import com.dilidili.enums.ErrorCodeIntEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一接口返回
 */
public class ResultUtil {
    final static String CODE = "code";

    final static String SUCCESS = "success";

    final static String ERROR = "error";

    final static String DATA = "data";

    final static String MESSAGE = "message";

    final static int NUM_TWO = 2;

    final static int NUM_THREE = 3;

    /**
     * @param code success error
     * @param data 返回的数据
     * @return
     */
    public static String result(Object code, Object data) {
        return resultWithData(code, data);
    }

    /**
     * 【只携带数据】
     *
     * @param code
     * @param data
     * @return
     */
    public static String resultWithData(Object code, Object data) {
        Map<Object, Object> map = new HashMap<Object, Object>(NUM_TWO);
        map.put(CODE, code);
        map.put(DATA, data);
        return JsonUtils.objectToJson(map);
    }

    /**
     * 返回结果【只携带消息】
     *
     * @param code success error
     * @return String
     */
    public static String resultWithMessage(Object code, String message) {
        Map<Object, Object> map = new HashMap<Object, Object>(NUM_TWO);
        map.put(CODE, code);
        map.put(MESSAGE, message);
        return JsonUtils.objectToJson(map);
    }

    /**
     * 返回成功的结果【只携带数据】
     *
     * @param data
     * @return
     */
    public static String successWithData(Object data) {
        return resultWithData(SUCCESS, data);
    }

    public static String responseWithCodeEnum(ErrorCodeIntEnum errorCodeIntEnum) {
        return resultWithMessage(errorCodeIntEnum.getCode(), errorCodeIntEnum.getMessage());
    }
}
