package com.dilidili.filter.service.manager;

import com.dilidili.filter.service.entity.Hit;
import com.dilidili.filter.service.entity.PatternFilterFunc;
import com.dilidili.filter.service.entity.PatternFilterResp;
import com.dilidili.filter.service.entity.api.Filter;
import com.dilidili.filter.service.entity.api.HitFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * FilterRaw，执行多态过滤器管理的一些逻辑，以及执行匹配完成后的一些命中位置的处理
 */
@Slf4j
@Component
public class FilterRawManager {

    /**
     * 创建正则字典树匹配返回的函数实现
     */
    public static PatternFilterFunc createPatternFilter(Filter filter, HitFilter... hitFilters) {
        return (req) -> {
            PatternFilterResp resp = new PatternFilterResp();
            List<Hit> hits = filter.filter(req.getAreaBO(), req.getText());

            OUTER:
            for (Hit hit : hits) {
                for (HitFilter hitFilter : hitFilters) {
                    if (!hitFilter.Hit((hit))) {
                        continue OUTER;
                    }
                }
                // 此时hit满足所有hitFilter情况，添加至返回
                resp.getHits().add(hit);
            }
            return resp;
        };
    }


}
