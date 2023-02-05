package com.dilidili.filter.service.entity.trie.impl;

import com.dilidili.filter.service.entity.Hit;
import com.dilidili.filter.service.entity.trie.trie.MapTrie;
import org.junit.jupiter.api.Test;

import java.util.List;

class MapTrieTest {

    @Test
    void insert() {
    }

    @Test
    void containsWord() {
        MapTrie<Integer> trie = new MapTrie<>();
        trie.insert("习近平", 18);
        boolean exist = trie.containsWord("习近平");
        System.out.println(exist);
    }

    @Test
    void filter() {
        MapTrie<Integer> trie = new MapTrie<>();
        trie.insert("习近平", 18);
        trie.insert("习近平主席", 20);
        List<Hit> res = trie.filter("你好，习近平；今天我吃了一碗饭，习近平主席吃了两碗");
        System.out.println(res);
    }


}