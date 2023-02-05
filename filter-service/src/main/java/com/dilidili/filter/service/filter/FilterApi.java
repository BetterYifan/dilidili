package com.dilidili.filter.service.filter;

import com.dilidili.filter.service.entity.Hit;
import com.dilidili.filter.service.entity.api.Filter;
import com.dilidili.filter.service.entity.bo.AreaBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class FilterApi {

    /**
     * ，敏感词过滤
     *
     * @param area
     * @param text
     * @return
     */
    public List<Hit> blackFilter(AreaBO area, String text) {
        List<Hit> blackHits = new ArrayList<>();
        return blackHits;
    }

    /**
     * 白名单过滤
     *
     * @param area
     * @param text
     * @return
     */
    public List<Hit> whiteFilter(AreaBO area, String text) {
        List<Hit> whiteHits = new ArrayList<>();
        return whiteHits;
    }

    /**
     * 对hits进行过滤
     *
     * @param blackHits
     * @param whiteHits
     * @return
     */
    public List<Hit> resolveHits(List<Hit> blackHits, List<Hit> whiteHits) {
        List<Hit> hits = new ArrayList<>();
        return hits;
    }

    /**
     * 混合过滤，同时过滤白名单和敏感词，并剔除了白名单命中的词
     *
     * @param area
     * @param text
     * @return
     */
    public List<Hit> MixFilter(AreaBO area, String text) {
        List<Hit> blackHits = blackFilter(area, text);
        List<Hit> whiteHits = whiteFilter(area, text);
        return resolveHits(blackHits, whiteHits);
    }

    public Filter SmartApiFilter(AreaBO area, String text) {
        return ((area1, text1) -> {
            List<Hit> hits = MixFilter(area, text);
            return hits;
        });
    }
}
