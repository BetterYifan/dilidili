package com.dilidili.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * controller入参的最上层类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest {
    /**
     * 链路追踪id
     */
    private String traceId;

    /**
     * 放入请求头，表示调用的业务方
     */
    private String caller;

    /**
     * 语言
     */
    private String language;
}
