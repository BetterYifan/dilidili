package com.dilidili.filter.service.entity.trie.impl;

import com.dilidili.filter.service.entity.Hit;
import com.dilidili.filter.service.entity.trie.AbstractTrie;
import com.dilidili.filter.service.entity.trie.TrieNode;
import com.dilidili.filter.service.entity.trie.node.HashMapNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MapTrie<V> implements AbstractTrie<V> {

    private TrieNode<V> root;

    public MapTrie() {
        this.root = createRootNode();
    }

    private TrieNode<V> createRootNode() {
        return new HashMapNode<V>(ROOT_WORD);
    }

    @Override
    public void print() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public List<Hit> filter(String text) {
        List<Hit> hits = new ArrayList<>();
        text = trimToLowerCase(text);

        TrieNode<V> cur = root;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (cur.containsChild(c)) {
                cur = cur.getChildByChar(c);
            }
            if (cur.isEnd()) {
                hits.add(Hit.builder()
                        .v(cur.getValue())
                        .pos(new int[]{i - cur.getWord().length(), i})
                        .build());
                // cur走到哪里?
                cur = root;
            }
        }
        return hits;
    }

    @Override
    public void insert(String word, V value) {
        if (word == null) {
            return;
        }
        word = trimToLowerCase(word);

        TrieNode<V> cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.containsChild(c)) {
                cur = cur.addChild(c);
            } else {
                cur = cur.getChildByChar(c);
            }
        }
        // 此时已经构建好了字典树，并cur为最后一个节点
        cur.setWord(word);
        cur.setValue(value);
    }

    @Override
    public void deleteWord(String word) {
        return;
    }

    @Override
    public boolean containsWord(String word) {
        if (word == null) {
            return false;
        }
        word = trimToLowerCase(word);

        TrieNode<V> cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.containsChild(c)) {
                cur = cur.getChildByChar(c);
            } else {
                return false;
            }
        }
        return cur.containsWord();
    }

    @Override
    public V getValue(String word) {
        return null;
    }

    @Override
    public List<String> keys() {
        return null;
    }

    /**
     * 将word转为小写
     *
     * @param word
     * @return
     */
    public String trimToLowerCase(String word) {
        return word.toLowerCase().trim();
    }


}
