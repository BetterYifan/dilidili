package com.dilidili.filter.service.manager;

import com.dilidili.filter.service.entity.PatternFilterReq;
import com.dilidili.filter.service.entity.PatternFilterResp;
import com.dilidili.filter.service.entity.RuleStock;
import com.dilidili.filter.service.entity.bo.AreaBO;
import com.dilidili.filter.service.entity.vo.FilterVO;
import com.dilidili.filter.service.filter.FilterApi;
import com.dilidili.filter.service.jobs.RuleArea;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterManager {
    @Autowired
    private RuleArea ruleArea;

    @Autowired
    private FilterApi filterApi;

    /**
     * 核心！
     * 执行敏感词匹配逻辑
     *
     * @param text
     * @param areaBO
     * @return
     */
    public FilterVO filter(String text, AreaBO areaBO) {
        FilterVO filterVO = new FilterVO();

        if (StringUtils.isBlank(text)) {
            return null;
        }

        // todo 1. 文本预处理

        //2. 生成record
        Record record = new Record(text);

        //3. todo并发执行filter
        PatternFilterResp resp = record.RunPatternFilter(FilterRawManager.createPatternFilter(filterApi.SmartApiFilter(areaBO, text)), PatternFilterReq.builder().build());

        //4. 聚合结果

        //todo 5. 上报es

        return filterVO;
    }


    /**
     * 返回area对应的黑名单词库
     *
     * @param area
     * @return
     */
    public List<RuleStock> BlackRuleStock(AreaBO area) {
        List<RuleStock> rss = new ArrayList<>();
        if (ruleArea.getAreaRuleStock().containsKey(area)) {
            rss.addAll(ruleArea.RuleStocks(area));
        }
        return rss;
    }


}
