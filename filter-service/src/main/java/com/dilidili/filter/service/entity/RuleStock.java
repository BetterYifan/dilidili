package com.dilidili.filter.service.entity;

import com.dilidili.filter.service.entity.regexp.Regexp;
import com.dilidili.filter.service.entity.trie.impl.MapTrie;

import java.util.List;

public class RuleStock {
    private MapTrie trie;

    private List<Regexp> regexpList;
}
