package com.dilidili.filter.service.entity;

@FunctionalInterface
public interface PatternFilterFunc {
    PatternFilterResp filter(PatternFilterReq req);
}
