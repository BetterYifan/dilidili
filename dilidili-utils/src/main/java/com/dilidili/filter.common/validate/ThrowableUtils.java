package com.dilidili.filter.common.validate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ThrowableUtils {
    /**
     * 校验参数正确,拼装字段名和值到错误信息
     *
     * @param result
     */
    public static void checkParamArgument(BindingResult result) {
        if (result != null && result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();

            String msg = result.getAllErrors().get(0).getDefaultMessage();
            sb.append(msg);
        }
    }
}
