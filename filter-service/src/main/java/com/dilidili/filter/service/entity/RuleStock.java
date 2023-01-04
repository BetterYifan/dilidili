package com.dilidili.filter.service.entity;

import com.dilidili.filter.service.entity.regexp.Regexp;
import com.dilidili.filter.service.entity.trie.Trie;

import java.util.List;

public class RuleStock {
    private Trie trie;

    private List<Regexp> regexpList;
}
