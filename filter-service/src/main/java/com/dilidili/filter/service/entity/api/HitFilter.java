package com.dilidili.filter.service.entity.api;

import com.dilidili.filter.service.entity.Hit;

/**
 * 执行完api.Filter后执行，对filter()的结果做过滤
 */
public interface HitFilter {
    // 判断Hit是否需要保留
    boolean Hit(Hit hit);
}
