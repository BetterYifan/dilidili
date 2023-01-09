package com.dilidili.filter.service.entity.trie.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}