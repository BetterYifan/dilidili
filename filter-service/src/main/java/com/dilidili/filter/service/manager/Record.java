package com.dilidili.filter.service.manager;

import com.dilidili.filter.service.entity.PatternFilterFunc;
import com.dilidili.filter.service.entity.PatternFilterReq;
import com.dilidili.filter.service.entity.PatternFilterResp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Record为抽象出的概念,可以保留许多过滤后的结果
 */
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    String text;


    public PatternFilterResp RunPatternFilter(PatternFilterFunc filterFunc, PatternFilterReq patternFilterReq) {
        PatternFilterResp resp = filterFunc.filter(patternFilterReq);
        // todo 上报record
        return resp;
    }

    public void RunAntispamFilter() {

    }

}
