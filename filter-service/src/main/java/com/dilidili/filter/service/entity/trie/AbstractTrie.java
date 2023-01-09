package com.dilidili.filter.service.entity.trie;

import com.dilidili.filter.service.entity.Hit;

import java.util.List;

public interface AbstractTrie<V> {
    char ROOT_WORD = ' ';

    void insert(String word, V value);

    void deleteWord(String word);

    boolean containsWord(String word);

    V getValue(String word);

    List<String> keys();

    void print();

    int size();

    void clear();

    List<Hit> filter(String text);
}
