package com.dilidili.filter.service.jobs;

import com.dilidili.filter.service.entity.RuleStock;
import com.dilidili.filter.service.entity.bo.AreaBO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Data
public class RuleArea {

    private Map<String, RuleStock> areaRuleStock;

    public List<RuleStock> RuleStocks(AreaBO areaBO) {
        List<RuleStock> rss = new ArrayList<>();
        if (areaRuleStock.containsKey(areaBO.getArea())) {
            rss.add(areaRuleStock.get(areaBO.getArea()));
        }
        return rss;
    }
}
