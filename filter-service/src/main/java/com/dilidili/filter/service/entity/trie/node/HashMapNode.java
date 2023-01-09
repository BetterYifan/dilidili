package com.dilidili.filter.service.entity.trie.node;

import com.dilidili.filter.service.entity.trie.TrieNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapNode<V> extends AbstractMapNode<V> {

    public HashMapNode(char character) {
        super(character);
    }

    @Override
    protected Map<Character, TrieNode<V>> onCreateMap() {
        return new LinkedHashMap<>();
    }

    @Override
    protected AbstractMapNode<V> onCreateNode(char character) {
        return new HashMapNode<>(character);
    }
}
